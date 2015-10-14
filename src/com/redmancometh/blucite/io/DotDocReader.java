package com.redmancometh.blucite.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.redmancometh.blucite.io.generics.DocReader;

public class DotDocReader extends DocReader
{
	public DotDocReader(File f)
	{
		super(f);
	}

	@Override
	public String readFile(File f)
	{
		XWPFWordExtractor extractor = null;
		FileInputStream fis = null;
		String fileData = null;
		try
		{
			fis = new FileInputStream(f.getAbsolutePath());
			XWPFDocument document = new XWPFDocument(fis);
			extractor = new XWPFWordExtractor(document);
			System.out.println("Extracting text...");
			fileData = extractor.getText();
			// fileData contains one continuous string that we will now begin
			// parsing out the footnotes
			// FootnoteExtractor fe = new FootnoteExtractor(fileData);
			// String[] footnotes = fe.getFootnotes();
			// fis.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return fileData;
	}
}
