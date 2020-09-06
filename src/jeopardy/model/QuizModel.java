package jeopardy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import jeopardy.Utils;
import jeopardy.util.FileHandler;

public class QuizModel {
	private int _winning;
	private int _remainingQuestion;
	private ArrayList<Category> _cats;
	private Question _activeQuestion;

	public QuizModel() {
		_winning = 0;
		_cats = FileHandler.loadCategory();
		
		
		updateRemainingQuestion();
	}
	
	/**
	 * Perform game feature of answering question, the method checks if the 
	 * answer is correct, update the score of the user, and return a boolean
	 * according to if the answer is correct or not.
	 * 
	 * @param question
	 * @param User input
	 * @return true if the answer is correct, else false
	 */
	public boolean answerQuestion(Question question, String input) {
		question.setAttempted(true);
		_remainingQuestion -= 1;
		if (question.getAnswer().equalsIgnoreCase(input)) {
			System.out.println("Correctly answer question");
			_winning += question.getScore();
			return true;
		} else {
			System.out.println("Not Correct answer for question");
			_winning -= question.getScore();
			return false;
		}

	}

	/**
	 * Count and update the question remaining, the function loop though
	 * all questions in the category and count the attempted function.
	 */
	public void updateRemainingQuestion() {
		_remainingQuestion = 0;
		for (Category cat : _cats) {
			for (Question question : cat.getQuestions()) {
				if (!question.isAttempted()) {
					_remainingQuestion += 1;
				}
			}
		}
	}
	/**
	 * Save the current user data to a file named user.save at The system directory
	 * The file is saved as an object which mimic a database
	 */
	public void save() {
		ObjectDB db = new ObjectDB();
		db.setWinning(_winning);
		HashMap<String, Boolean> isAttemptedMap = new HashMap<String, Boolean>();
		for (Category cat : _cats) {
			for (Question question : cat.getQuestions()) {
				isAttemptedMap.put(question.toString(), question.isAttempted());
			}
		}
		db.setIsAttemptedMap(isAttemptedMap);
		FileHandler.saveDB(db);
	}
	
	/**
	 * 
	 */
	public void load() {
		ObjectDB db = FileHandler.loadDB();
		_winning = db.getWinning();
		Map<String, Boolean> isAttemptedMap = db.getIsAttemptedMap();
		
		//TODO handle exception
		for (Category cat : _cats) {
			for (Question question : cat.getQuestions()) {
				if (isAttemptedMap.get(question.toString()) == true) {
					question.setAttempted(true);
				}
			}

		}
		updateRemainingQuestion();
	}
	
	/**
	 * Rest the game of the session, the user score is reset to 0
	 * and all attempted question will be set to its non attempted status
	 */
	public void reset() {
		_winning = 0;
		_remainingQuestion = 0;
		for (Category cat : _cats) {
			for (Question question : cat.getQuestions()) {
				question.setAttempted(false);
				_remainingQuestion += 1;
			}
		}
	}

	
	/**
	 * TextToSpeech function using festival bash command.
	 * @param text to be turned into speach
	 */
	public void textToSpeech(String text) {
		System.out.println("Text to speach is called: " + text);
		new Thread(new Runnable() {
			@Override
			public void run() {
				String command = "echo \"" + text + "\" | festival --tts";
				Utils.runBash(command);
			}

		}).start();
	}

	/**
	 * Set Method. set the active question
	 * @param question
	 */
	public void setActiveQuestion(Question question) {
		_activeQuestion = question;
	}
	/**
	 * Get Method
	 * @return current selected question
	 */
	public Question getActiveQuestion() {
		return _activeQuestion;
	}
	/**
	 * Get Method
	 * @return all Category
	 */
	public ArrayList<Category> getCategoryList() {
		return _cats;
	}
	/**
	 * Get Method
	 * @return score of the player
	 */
	public int getWinning() {
		return _winning;
	}
	/**
	 * Get Method
	 * @return total question left
	 */
	public int getRemainingQuestionCount() {
		return _remainingQuestion;
	}

}
