package com.sarat.designPatterns.behavioral_Design_Patterns.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementations of java.lang.Runnable and javax.swing.Action 
 * @author Sarat Behera
 *
 */
public class CommandGOF {
	
	interface Command {		
		void run();
	}
	
	public static class Logger implements Command{
		public final String message;		
		public Logger(String message) {
			this.message = message;
		}		
		@Override
		public void run() {
			System.out.println("Logger :: "+ message);			
		}		
	}
	
	public static class FileSaver implements Command{
		public final String message;		
		public FileSaver(String message) {
			this.message = message;
		}		
		@Override
		public void run() {
			System.out.println("Saving :: "+ message);			
		}		
	}
	
	public static class Mailer implements Command{
		public final String message;		
		public Mailer(String message) {
			this.message = message;
		}		
		@Override
		public void run() {
			System.out.println("Mail Sent :: "+ message);			
		}		
	}
	
	public static class Executor {
		public void execute(List<Command> tasks) {
			for(Command task : tasks) {
				task.run();
			}
		}
	}

	public static void main(String[] args) {
		List<Command> tasks = new ArrayList<>();
		tasks.add(new Logger("Hi"));
		tasks.add(new FileSaver("Cheers"));
		tasks.add(new Mailer("Bye"));
		
		new Executor().execute(tasks);

	}

}
