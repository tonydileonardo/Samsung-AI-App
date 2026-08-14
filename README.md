# Samsung-AI-App

Minimal Python starter app for a Samsung smartphone workflow using Azure:

- Speech-to-Text (STT) with Azure Speech
- Text-to-Speech (TTS) with Azure Speech
- Azure AI Foundry client initialization

## 1) Create a virtual environment

```bash
python -m venv .venv
source .venv/bin/activate
```

## 2) Install dependencies

```bash
pip install -r requirements.txt
```

## 3) Configure environment variables

```bash
cp .env.example .env
```

Set values in `.env`:

- `AZURE_SPEECH_KEY`
- `AZURE_SPEECH_REGION`
- `AZURE_AI_FOUNDRY_PROJECT_CONNECTION`

## 4) Run

```bash
python main.py --text "Hello from Samsung AI App"
```

This will synthesize speech with Azure TTS and print status messages. You can use the helper
functions in `main.py` to wire STT/TTS into your mobile app flow.
