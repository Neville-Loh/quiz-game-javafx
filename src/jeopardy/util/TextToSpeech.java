package jeopardy.util;

import jeopardy.Utils;

public class TextToSpeech {
	private String _text;
	
	public TextToSpeech(String text) {
		_text = text;
	}
	
	
	public void speak() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String command = "echo " + _text + " | festival --tts";
				BashCommand bc = new BashCommand(command);
				bc.start();
			}

		}).start();
	}
	
	public void stop() {
		
	}
	public String getText() {
		return _text;
	}
	
}
