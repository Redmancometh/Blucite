package com.redmancometh.blucite.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import com.redmancometh.blucite.io.generics.DocReader;

public class PDFReader extends DocReader
{

	public PDFReader(File f)
	{
		super(f);
	}

	@Override
	public String readFile(File f)
	{
		String text = null;
		InputStream is = null;
		try
		{
			is = new FileInputStream(f);
			ContentHandler contentHandler = new BodyContentHandler();
			Metadata metadata = new Metadata();
			PDFParser pdfparser = new PDFParser();
			pdfparser.parse(is, contentHandler, metadata, new ParseContext());
			text = contentHandler.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (is != null)
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		}
		return text;
	}

}
