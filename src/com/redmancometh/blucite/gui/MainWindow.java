package com.redmancometh.blucite.gui;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.redmancometh.blucite.io.constants.BluReader;
import com.redmancometh.blucite.io.generics.DocReader;
@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
	private Map<String, File> fileMap = new ConcurrentHashMap();
	DefaultListModel model = new DefaultListModel();
	JFileChooser chooser = new JFileChooser();
	JFrame mainWindow = new JFrame("BluCite");
	JButton selectDocument = new JButton("Select Document");
	JButton parseDocument = new JButton("Parse Document");
	JList list = new JList();
	public void init()
	{
		mainWindow.setLayout(null);
		initButtons();
		initLists();
		initFilters();
		setListeners();
		mainWindow.setSize(800, 600);
		mainWindow.setVisible(true);
	}
	
	public void initFilters()
	{
		FileFilter[] filters = new FileFilter[4];
		filters[0] = new FileNameExtensionFilter("New Word Format (.docx)", "docx");
		filters[1] = new FileNameExtensionFilter("PDF File (.pdf)", "pdf");
		filters[2] = new FileNameExtensionFilter("Text File (.txt)", "txt");
		filters[3] = new FileNameExtensionFilter("Old Word Format (.doc)", "doc");
		for(FileFilter inFilter : filters)
		{
			chooser.addChoosableFileFilter(inFilter);
		}
	}

	public void initLists()
	{
		list.setBounds(250, 50, 300, 30);
		list.setModel(model);
		list.setVisibleRowCount(5);
		mainWindow.add(list);
	}

	public void addToList(String name)
	{
		model.addElement(name);
		resizeList();
	}

	public void resizeList()
	{
		if (list.getVisibleRowCount() < 20)
		{
			list.setVisibleRowCount(list.getVisibleRowCount() + 1);
		}
		if (list.getBounds().getWidth() < 800)
		{
			Rectangle rect = list.getBounds();
			rect.setBounds(rect.x, rect.y, rect.width, rect.height + 15);
			list.setBounds(rect);
		}
	}

	public void initButtons()
	{
		selectDocument.setBounds(30, 50, 150, 30);
		parseDocument.setBounds(30, 80, 150, 30);
		mainWindow.getContentPane().add(parseDocument);
		mainWindow.getContentPane().add(selectDocument);
	}

	public void setListeners()
	{
		selectDocument.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				chooser.showOpenDialog(rootPane);
				File f = chooser.getSelectedFile();
				if(f==null)
				{
					return;
				}
				fileMap.put(f.getName(), f);
				addToList(f.getName());
			}
		});
		parseDocument.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String fileName = (String) list.getSelectedValue();
				if(fileName!=null)
				{
					File f = getFileFromName((String) list.getSelectedValue());
					DocReader reader = BluReader.getReader(f);  // No idea how to paramaterize types in ListModels
					System.out.println(reader.readFile(f));
				}
			}
		});
	}
	
	public File getFileFromName(String fileName)
	{
		return fileMap.get(fileName);
	}
}
