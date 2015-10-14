package com.redmancometh.blucite.gui;

import javax.swing.JFrame;
import javax.swing.JTextPane;
public class ViewFileWindow
{
	private String title;
	JFrame window = new JFrame(title);
	JTextPane textBox = new JTextPane();
	public ViewFileWindow(String title, String text)
	{
		this.title=title;
		window.setLayout(null);
		window.setSize(800, 800);
		window.add(textBox);
		textBox.setText(text);
		textBox.setBounds(0, 0, 700, 1000);
	}
	public void initWindow()
	{
		window.setVisible(true);
	}
}
