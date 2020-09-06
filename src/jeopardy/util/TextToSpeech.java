package jeopardy.util;

import jeopardy.Utils;

public class TextToSpeech {
	private String _text;
	private BashCommand bc;
	
	public TextToSpeech(String text) {
		_text = text;
	}
	
	/**
	 * 
	 */
	public void speak() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String command = "echo " + _text + " | festival --tts";
				bc = new BashCommand(command);
				bc.start();
			}

		}).start();
	}
	
	/**
	 * Stop and kill the text to speech
	 */
	public void stop() {
		bc.kill();
	}
	/**
	 * Get Method
	 * @return return input text of the texttoSpeech
	 */
	public String getText() {
		return _text;
	}
	
}
