package com.redmancometh.blucite.io.generics;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unused")
public abstract class DocReader
{
	private File inputFile;
	//private Map<Integer, String> citeMap = new ConcurrentHashMap();
	public DocReader(File f)
	{
		this.inputFile = f;
	}

	public boolean doesExist()
	{
		if (inputFile.exists())
		{
			return true;
		}
		return false;
	}
	
	public void extractFootNotes(String line)
	{
		
	}

	public abstract String readFile(File f);
}
