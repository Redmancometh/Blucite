package com.redmancometh.blucite.io;

/**
 * Created by ColinForage on 9/21/15.
 */
import java.io.*;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.redmancometh.blucite.io.generics.DocReader;
public class DocXReader extends DocReader
{

	public DocXReader(File f)
	{
		super(f);
	}

	@Override
	public String readFile(File file)
	{
		XWPFWordExtractor extractor = null;
		FileInputStream fis = null;
		String fileData = null;
		try
		{
			fis = new FileInputStream(file.getAbsolutePath());
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
		return fileData;
	}
}
