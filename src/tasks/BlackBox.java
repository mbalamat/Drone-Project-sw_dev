package tasks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class BlackBox {
	private String log = "~~~~~~Head of the log file of the drone's BlackBox system, this line was generated automatically~~~~~~";
	private boolean sent = false;

	public void logActivity(String x) {
		log = log + "\n" + x;
	}

	public void writeFile() {
		try {
			File file = new File("blackboxlog.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(log);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean sendLogFile() {
		// acts to send log file
		sent = true;
		System.out.println(log);
		writeFile();// check for issues later
		return sent;
	}
	
	
	
	//testing 
	
//	 public static void main(String[] args){
//	 BlackBox bb1 = new BlackBox();
//	 bb1.logActivity("Something");
//	 bb1.logActivity("SomethingMore");
//	 bb1.logActivity("SomethingLess");
//	 bb1.logActivity("SomethingMore");
//	 bb1.logActivity("SomethingLess");
//	 bb1.logActivity("SomethingMore");
//	 bb1.sendLogFile();
//	
//	 }
}
