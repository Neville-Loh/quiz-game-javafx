package jeopardy.model;

import java.util.ArrayList;

/**
 * Class to represent the organization of the category, which catgoriy contain
 * multiple questions, for example 5 question per category
 * 
 * @author Neville
 */
public class Category {
	private ArrayList<Question> _questions;
	private String _title;
	
	public Category(String title) {
		_title = title;
		_questions = new ArrayList<Question>();
	}
	
	/**
	 * Add a question to a category 
	 * @param q
	 */
	public void add(Question q) {
	_questions.add(q);
	}
	
	/**
	 * Gets the Title of the category
	 * @return Title of the category
	 */
	public String getTitle() {
		return _title;
	}
}
