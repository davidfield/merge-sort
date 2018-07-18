package com.mergesort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileMerge {
	
	public File sort(File sourceFile, File targetFile) {
		
		// Split source file into smaller files
		List<File> files = splitSourceFile(sourceFile, "splitFile");
		
		// Sort individual files
		for (File file: files) {
			sortFile(file);
		}
		
		// Create FileIterator objects for each file
		List<FileIterator> fileIterators = createFileIterators(files);
		
		doSort(fileIterators, targetFile);
		return targetFile;
	}
	
	public List<File> splitSourceFile(File sourceFile, String baseFileName) {
		List<String> lines = new ArrayList<String>();
		List<File> files = new ArrayList<File>();
		int fileCount = 0;
		File file = new File(baseFileName+Integer.toString(fileCount));

		try {
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			String line;
			int lineCount = 0;
			//while (true) {
			while((line=br.readLine())!=null){
			//st = br.readLine();
				lineCount ++;
				if (lineCount>4 ) {
					FileUtils.writeFile(lines, file);
					files.add(file);
					lines = new ArrayList<String>();
					lineCount=1;
					file = new File(baseFileName+Integer.toString(++fileCount));
					
				}
				lines.add(line);
				System.out.println("in splitSourceFile, file:"+fileCount+" string:"+line);

			}
			if (lineCount<=4){
				FileUtils.writeFile(lines, file);
				files.add(file);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return files;
	}
	
	public void sortFile(File file) {
		List<String> lines = FileUtils.readFile(file);
		Collections.sort(lines);
		FileUtils.writeFile(lines, file);
		
	}
	
	public List<FileIterator> createFileIterators(List<File> files) {
		List<FileIterator> fileIterators = new ArrayList<FileIterator>();
		for (File file: files) {
			fileIterators.add(new FileIterator(file));
		}
		return fileIterators;
	}
	
	public File doSort(List<FileIterator> fileIterators, File targetFile) {
		
		while (true) {
			Collections.sort(fileIterators);
			FileIterator fileWithLowestNextValue = fileIterators.iterator().next();
			// Because of the FileIterator sort algorithm, 
			// if the first iterator in the collection has been fully traversed, we know we are done
			if (fileWithLowestNextValue.getNextValue()==null ) {
				break;
			}
			
			// Write line to target file
			FileUtils.writeFile(fileWithLowestNextValue.nextVal, targetFile);

			// Increment iterator
			fileWithLowestNextValue.iterateToNext();
		}
		
		
		return targetFile;
	}
	
	

}
