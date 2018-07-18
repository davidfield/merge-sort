package com.mergesort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static List<String> readFile(File file) {

		List<String> lines = new ArrayList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			
			while((line=br.readLine())!=null){
		    	lines.add(line);
		        System.out.println("READING IN:"+line);
		     }
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines;
	}


	public static void writeFile(List<String> lines, File file) {
		try {

			   file.delete();
			   file.createNewFile();

			FileWriter writer = new FileWriter(file, false);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			for (String line: lines) {
				bufferedWriter.write(line);
				System.out.println("WRITING LINE:"+line);
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeFile(String line, File file) {
		try {
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			
				bufferedWriter.write(line);
				System.out.println("WRITING LINE:"+line);
				bufferedWriter.newLine();
			

			bufferedWriter.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
