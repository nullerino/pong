package com.nullerino.gui;

import javax.swing.JFrame;

import com.nullerino.game.Pong;

public class Frame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pong game;

	public Frame()
	{
		game = new Pong();
		this.setResizable(false);
		this.setTitle(game.getGAME_NAME() + " v" + game.getVERSION());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(game);
	}

	public void start()
	{
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		game.run();
	}

	public static void main(String[] args)
	{
		Frame frame = new Frame();
		frame.start();
	}
}