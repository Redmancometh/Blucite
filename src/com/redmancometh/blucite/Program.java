package com.redmancometh.blucite;
import java.io.File;
import java.util.Scanner;

import com.redmancometh.blucite.io.DocXReader;
public class Program
{
	static Scanner in = new Scanner(System.in);
	public static void main(String[] strings)
	{
		File file = new File(strings[0]); //Will be from GUI later
		DocXReader reader = new DocXReader(file);
		if(!reader.doesExist())
		{
			System.out.println("This file does not exist! Input new file.");
			String newFile = in.nextLine();
			main(new String[]{newFile});
		}
		else
		{
			reader.readFile(file);
		}
	}

}
