package com.redmancometh.blucite.io.generics;

import java.io.File;

public abstract class DocReader
{
	private File inputFile;

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

	public abstract String readFile(File f);
}
