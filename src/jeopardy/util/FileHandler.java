package jeopardy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jeopardy.model.Category;
import jeopardy.model.ObjectDB;
import jeopardy.model.Question;

/**
 * Utility class which handle all the loading and saving, writing logs file in
 * the jeopardy application.
 * 
 * @author Neville
 *
 */
public class FileHandler {

	/**
	 * Load category in the
	 * 
	 * @param path of the folder.
	 * @return Category List which contain all the questions
	 */
	public static ArrayList<Category> loadCategory(String path) {

		ArrayList<Category> result = new ArrayList<Category>();
		int score;
		String questionPrompt;
		String answer;

		try {
			path = System.getProperty("user.dir") + File.separator +"categories";
			System.out.println(path);
			File folder = new File(path);

			// Looping though each category
			for (File fileEntry : folder.listFiles()) {
				Category category = new Category(fileEntry.getName());
				BufferedReader br = new BufferedReader(new FileReader(fileEntry));

				// Read every line of category
				String line;
				while ((line = br.readLine()) != null) {
					String[] strList = line.split(",");

					score = Integer.parseInt(strList[0]);
					questionPrompt = strList[1];
					answer = strList[2];

					Question question = new Question(questionPrompt, answer, score);
					category.add(question);
				}

				result.add(category);
				br.close();
			}
			
		} catch (Exception e) {
			System.out.println("loadCategory error");
			e.printStackTrace();
		}

		return result;
	}

	public static void saveDB(ObjectDB db) {
		String FILENAME = "user.save";
		// Save Object
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
			oos.writeObject(db);

			System.out.println("DB has been saved");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ObjectDB loadDB() {
		String FILENAME = "user.save";
		ObjectDB db = null;
		// Read Object
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
			db = (ObjectDB) ois.readObject();
		} catch (Exception e) {
			System.out.println("DB loading error");
			e.printStackTrace();
		}
		return db;

	}

}
