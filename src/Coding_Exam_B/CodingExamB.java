package Coding_Exam_B;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodingExamB {
	/*
	 * This is a logging program for collecting TODO comments in a program. The program will scan
	 * Through all the files in the Coding_Exam_B/classes package, and collect all the comments that start
	 * with //TODO: and write them to their own file. See the TODO_Log_example.txt file for an idea of what 
	 * the final file output will look like.
	 */
	BufferedReader fr;
	
	public static String getLoggingInfo(String fileName) {
		String todos = "";
		String currentLine = "";
		/*
		 * 1. Complete the getLoggingInfoMethod.
		 *    The method takes in a String for a file and returns a String. 
		 *    The method will open the file a read through it. It will then 
		 *    take all the comments that begin with //TODO: and combine them 
		 *    into one large String. The string will also state the file name and
		 *    the line number for where each TODO was found. 
		*/
		try {
			BufferedReader fr = new BufferedReader(new FileReader(fileName));
			try {
				currentLine = fr.readLine();
				todos = todos + "File: " + fileName + "\n";
				int lineCounter = 0;
				while ((currentLine = fr.readLine()) != null) {
					lineCounter++;
					if (currentLine.contains("//TODO:")) {
						todos = todos + lineCounter + ": " + currentLine.trim() + "\n";
						}
		         }    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		//System.out.println(todos);
		return todos;
	}
	
	public static void main(String[] args) {
		String finalLogString = getLoggingInfo("src/Coding_Exam_B/classes/Camera.java") + "\n";
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracedImageViewer.java") + "\n";
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracer.java") + "\n";
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/Vector3.java") + "\n";
		System.out.println(finalLogString);
		/*
		 * 2. Write the finalLogString to a file called TODO_Log.txt. The file should match TODO_Log_example.txt. 
		 */
		try {
			FileWriter fw = new FileWriter("src/Coding_Exam_B/TODO_Log");
			fw.write(finalLogString);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
