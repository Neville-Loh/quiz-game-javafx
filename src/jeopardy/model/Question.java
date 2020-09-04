package jeopardy.model;

/**
 * Class for implementation of the question data structure, the class stores the
 * question prompt, the answer and score of the question. 
 * 
 * @author Neville
 */
public class Question {
	private String _question;
	private String _answer;
	private int _score;
	
	public Question(String question, String ans, int score) {
		_answer = ans;
		_question = question;
		_score = score;
	}
	
	
	@Override
	public String toString() {
		return _question;
	}
	
	/**
	 * Get Method, get the answer of the question
	 * @return Answer
	 */
	public String getAnswer() {
		return _answer;
	}
	
	/**
	 * Get the score of the question
	 * @return question Score
	 */
	public int getScore() {
		return _score;
	}
}
