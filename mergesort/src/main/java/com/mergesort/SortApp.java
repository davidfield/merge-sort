package com.mergesort;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SortApp {
	
	public static void main(String[] args){
		
		String sourceFileName = "sourceFile44";
		File sourceFile = createSourceFile(sourceFileName);
		FileMerge fileMerge = new FileMerge();
		File  targetFile = fileMerge.sort(sourceFile, new File("targetFile44"));
		System.out.println("***** TARGET FILE *****");
		FileUtils.readFile(targetFile);
		
	}
	
	private static File createSourceFile(String fileName) {
		List<String> lines = new ArrayList<String>();
		lines.add("line 9");
		lines.add("line 5");
		lines.add("line 8");
		lines.add("line 2");
		lines.add("line 10");
		lines.add("line 3");
		lines.add("line 1");
		lines.add("line 4");
		lines.add("line 12");
		lines.add("line 7");
		lines.add("line 11");
		lines.add("line 6");
		lines.add("line 88");
		File sourceFile = new File(fileName);
		FileUtils.writeFile(lines, sourceFile);
		
		FileUtils.readFile(sourceFile);
		
		System.out.println("*************");
//		if(1==1) System.exit(0);
		return sourceFile;
	}

}
