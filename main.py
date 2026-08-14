import argparse
import os

from dotenv import load_dotenv


load_dotenv()


def _required_env(name: str) -> str:
    value = os.getenv(name)
    if not value:
        raise ValueError(f"Missing required environment variable: {name}")
    return value


def create_speech_config():
    from azure.cognitiveservices.speech import SpeechConfig

    speech_key = _required_env("AZURE_SPEECH_KEY")
    speech_region = _required_env("AZURE_SPEECH_REGION")
    return SpeechConfig(subscription=speech_key, region=speech_region)


def synthesize_text(text: str):
    from azure.cognitiveservices.speech import SpeechSynthesizer

    speech_config = create_speech_config()
    synthesizer = SpeechSynthesizer(speech_config=speech_config)
    return synthesizer.speak_text_async(text).get()


def recognize_once():
    from azure.cognitiveservices.speech import SpeechRecognizer

    speech_config = create_speech_config()
    recognizer = SpeechRecognizer(speech_config=speech_config)
    return recognizer.recognize_once_async().get()


def create_ai_foundry_client():
    from azure.ai.projects import AIProjectClient
    from azure.identity import DefaultAzureCredential

    connection = _required_env("AZURE_AI_FOUNDRY_PROJECT_CONNECTION")
    return AIProjectClient.from_connection_string(
        conn_str=connection,
        credential=DefaultAzureCredential(),
    )


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument(
        "--text",
        default="Hello from Samsung AI App",
        help="Text to synthesize with Azure TTS",
    )
    args = parser.parse_args()

    synthesize_text(args.text)
    print("TTS request sent successfully.")


if __name__ == "__main__":
    main()
