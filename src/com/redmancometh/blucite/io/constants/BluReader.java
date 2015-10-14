package com.redmancometh.blucite.io.constants;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.io.FilenameUtils;
import com.redmancometh.blucite.io.DocXReader;
import com.redmancometh.blucite.io.DotDocReader;
import com.redmancometh.blucite.io.TxtReader;
import com.redmancometh.blucite.io.generics.DocReader;
public enum BluReader
{
	TXT(TxtReader.class, "txt"), DOC(DotDocReader.class, "doc"), DOCX(DocXReader.class, "docx");
	private String extension;
	private Class type;
	BluReader(Class c, String extension)
	{
		this.type=c; 
		this.extension=extension;
	}
	
	public static DocReader getReader(File f)
	{
		for(BluReader r : BluReader.values())
		{
			if(FilenameUtils.getExtension(f.getName()).equalsIgnoreCase(r.extension))
			{
				return r.instantiateReader(f);
			}
		}
		return null;
	}
	
	public DocReader instantiateReader(File f)
	{
		try
		{
			return (DocReader) this.type.getConstructor(File.class).newInstance(f);
		}
		catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
