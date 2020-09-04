package jeopardy.model;

import java.util.ArrayList;

public class QuizModel {
	private int _winning;
	private int _remainingQuestion;
	private ArrayList<Category> _cats;
	
	private Question _activeQuestion;
	
	
	public QuizModel() {
		_winning = 1000;
		_remainingQuestion = 20;
		_cats = getDummyCats();
		
		
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
	 * @return score of the player
	 */
	public int getWinning() {
		return _winning;
	}
	
	/**
	 * Get Method
	 * @return total questoin left
	 */
	public int getRemainingQuestionCount(){
		return _remainingQuestion;
	}
	
	//---------------------------------------------------------------------------------------------------------
	/**
	 * Get a dummy test question for testing purposes.
	 * @return
	 */
	public Question gettestQuestion() {
		return _cats.get(0).get(1);
	}
	
	public boolean answerQuestion(Question question, String input) {
		if (question.getAnswer().equalsIgnoreCase(input)){
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
	 * Create a dummy category for testing purposes.
	 * @return
	 */
	private ArrayList<Category> getDummyCats(){
		Question Q1 = new Question("Why is SE so hard c1q1", "cause I am dumb" ,100);
		Question Q2 = new Question("Why is SE so hard c1q2", "cat 1 q2 ans" ,200);
		Question Q3 = new Question("Why is SE so hard c1q3", "cat 1 q3 ans" ,300);
		Question Q4 = new Question("Why is SE so hard c1q4", "cat 1 q4 ans" ,400);
		Question Q5 = new Question("Why is SE so hard c1q5", "cat 1 q5 ans" ,500);
		Question Q6 = new Question("Why is SE so hard c2q1", "cat 2 q1 ans" ,200);
		Question Q7 = new Question("Why is SE so hard c2q2", "cat 2 q2 ans" ,200);
		Question Q8 = new Question("Why is SE so hard c2q3", "cat 2 q3 ans" ,300);
		Question Q9 = new Question("Why is SE so hard c2q4", "cat 2 q4 ans" ,400);
		Question Q10 = new Question("Why is SE so hard c@q5", "cat 2 q5 ans" ,500);
		
		Category cat1 = new Category("Animal");
		cat1.add(Q1);
		cat1.add(Q2);
		cat1.add(Q3);
		cat1.add(Q4);
		cat1.add(Q5);
		
		Category cat2 = new Category("Country");
		
		cat2.add(Q6);
		cat2.add(Q7);
		cat2.add(Q8);
		cat2.add(Q9);
		cat2.add(Q10);
		
		ArrayList<Category> dumbCat = new ArrayList<Category>();
		dumbCat.add(cat1);
		dumbCat.add(cat2);
		return dumbCat;
	}

	public void reset() {
		// TODO Auto-generated method stub
		System.out.println("model rest is called");
	}
	

}
