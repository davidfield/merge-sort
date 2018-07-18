package com.mergesort;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class FileIterator implements Comparable<FileIterator>{
	
	File file = null;
	Iterator<String> iter = null;
	String nextVal = null;
	
	public FileIterator(File file) {
		this.file = file;
		List<String> lines = FileUtils.readFile(file);
		iter = lines.iterator();
		setNextValue(iter.next());
		
	}
	
	public void setNextValue(String nextVal) {
		this.nextVal = nextVal;
	}
	
	public String getNextValue(){
		return nextVal;
	}
	
	public void iterateToNext() {
		if (iter.hasNext()) {
			setNextValue(iter.next());
		} else {
			setNextValue(null);
		}
		
	}

	@Override
	public int compareTo(FileIterator fi) {
		if (getNextValue()==null) {
			return 1;
		} else  if (fi.nextVal==null){
			return -1;
		}
		else {
		   return nextVal.compareTo(fi.nextVal);
		}
	}
	


}
