package com.redmancometh.blucite.gui;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;

@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
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
		setListeners();
		mainWindow.setSize(800, 600);
		mainWindow.setVisible(true);
	}

	public void initLists()
	{
		list.setBounds(250, 50, 300, 30);
		list.setModel(model);
		list.setVisibleRowCount(5);
		mainWindow.add(list);
	}
	
	public void addToList(File file)
	{
		model.addElement(file);
		resizeList();
	}
	
	public void resizeList()
	{
		if(list.getVisibleRowCount()<20)
		{
			list.setVisibleRowCount(list.getVisibleRowCount()+1);
		}
		if(list.getBounds().getWidth()<800)
		{
			Rectangle rect = list.getBounds();
			rect.setBounds(rect.x, rect.y, rect.width, rect.height+15);
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
				addToList(chooser.getSelectedFile());
			}
		});
	}
}
