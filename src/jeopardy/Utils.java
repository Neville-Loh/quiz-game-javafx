package jeopardy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Map;

public class Utils {
	public static void runBash(String command) {
		

		try {
			ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);

			Process process = pb.start();
			
//			// get pid
//			int pid = -1;
//			if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
//				Field pidField = process.getClass().getDeclaredField("pid");
//				pidField.setAccessible(true);
//				pid = pidField.getInt(process);
//
//				String killCommand = "kill -STOP " + pid;
//				ProcessBuilder killBuilder = new ProcessBuilder("bash", "-c", killCommand);
//				killBuilder.start();
//			}
//
//			
//			// -CONT
//			if (pid != -1) {
//				String contCommand = "kill -CONT " + pid;
//				ProcessBuilder contBuilder = new ProcessBuilder("bash", "-c", contCommand);
//				contBuilder.start();
//			}
			
			BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			int exitStatus = process.waitFor();
			
			if (exitStatus == 0) {
				String line;
				while ((line = stdout.readLine()) != null) {
					System.out.println(line);
				}
			} else {
				String line;
				while ((line = stderr.readLine()) != null) {
					System.err.println(line);
				}
			}
			process.destroy();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
