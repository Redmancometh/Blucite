package com.redmancometh.blucite.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class ViewFileWindow
{
	private String title;
	JFrame window = new JFrame(title);
	JTextPane textBox = new JTextPane();
	JButton matchButton = new JButton("Match");
	private Pattern regA = Pattern.compile("\\[\\d+:[a-zA-Z0-9 ].*");

	public ViewFileWindow(String title, String text)
	{
		this.title = title;
		window.setLayout(null);
		window.setSize(800, 800);
		window.add(textBox);
		textBox.setText(text);
		textBox.setBounds(0, 0, 700, 1000);
	}

	public void initWindow()
	{
		initButtons();
		window.setVisible(true);
	}

	public void initButtons()
	{
		matchButton.setBounds(750, 30, 150, 30);
		window.add(matchButton);
		setActions();
	}

	public void setActions()
	{
		matchButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Matcher m = regA.matcher(textBox.getText());
				while(m.find())
				{
					System.out.println(m.toMatchResult().group());
				}
			}
		});
	}
}
