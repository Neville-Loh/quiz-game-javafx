package jeopardy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
/**
 * Utility class for running Linux bash command using process builder.
 * @author Neville
 *
 */
public class BashCommand {
	
	private int pid = -1;
	private String command;
	private String stdout;
	private String stderr;
	
	/**
	 * Constructor, make a new runnable Bash command.
	 * @param command
	 */
	public BashCommand(String command) {
		this.command = command;
	}
	
	/**
	 * Method which Start and runs the bash command, this method also populate the process id,
	 * pid of the bash process. This is done to get reference to the process in situation 
	 * where user wish to kill the process.
	 */
	public void start() {
		try {
			ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
			Process process = pb.start();
			
			// Get the pid of the process.
			if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
				Field pidField = process.getClass().getDeclaredField("pid");
				pidField.setAccessible(true);
				pid = pidField.getInt(process);

				String killCommand = "kill -STOP " + pid;
				ProcessBuilder killBuilder = new ProcessBuilder("bash", "-c", killCommand);
				killBuilder.start();
			}
			
			
			// direct standard input to console terminal
			BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			int exitStatus = process.waitFor();
			
			if (exitStatus == 0) {
				String line;
				while ((line = stdoutReader.readLine()) != null) {
					stdout += line +"\n";
					System.out.println(line);
				}
			} else {
				String line;
				while ((line = stderrReader.readLine()) != null) {
					stderr += line +"\n";
				}
			}
			process.destroy();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Kill the current process of the bash command. Note, user can not kill a command which
	 * has not been started.
	 */
	public void kill() {
		try {
			if (pid != -1) {
				System.out.println("killling command");
				String killCommand = "kill " + pid;
				ProcessBuilder killBuilder = new ProcessBuilder("bash", "-c", killCommand);
				killBuilder.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get method
	 * @return standard output of the started command
	 */
	public String getStdout() {
		return stdout;
	}
	
	/**
	 * Get method
	 * @return standard error of the started command 
	 */
	public String getStderr() {
		return stderr;
	}
}
