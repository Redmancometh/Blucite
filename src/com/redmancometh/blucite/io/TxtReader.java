package com.redmancometh.blucite.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.redmancometh.blucite.io.generics.DocReader;

public class TxtReader extends DocReader
{

	public TxtReader(File f)
	{
		super(f);
	}

	@Override
	public String readFile(File f)
	{
		String fullText = null;
		BufferedReader r = null;
		FileReader inStream = null;
		if(super.doesExist())
		{
			String textLine;
			try
			{
				r = new BufferedReader((inStream=new FileReader(f)));
				while((textLine=r.readLine())!=null)
				{
					fullText+=textLine;
				}
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					inStream.close();
					r.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			System.out.println("File does not exist!");
		}
		return fullText;
	}

}
