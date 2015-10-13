package com.redmancometh.blucite.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
	JFileChooser chooser = new JFileChooser();
	JFrame mainWindow = new JFrame();
	JButton selectDocument = new JButton("Select Document");
	JButton parseDocument = new JButton("Parse Document");

	public void init()
	{
		initButtons();
		setListeners();
		mainWindow.setVisible(true);
		mainWindow.setSize(800, 600);
	}

	public void initButtons()
	{
		selectDocument.setSize(30, 30);
		parseDocument.setSize(30, 30);
		mainWindow.add(parseDocument);
		mainWindow.add(selectDocument);
	}

	public void setListeners()
	{
		selectDocument.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				chooser.showOpenDialog(rootPane);
				System.out.println(chooser.getSelectedFile());
			}
		});
	}
}
