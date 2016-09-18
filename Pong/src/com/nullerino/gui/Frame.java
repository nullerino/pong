package com.nullerino.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.nullerino.game.Pong;

public class Frame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	private final String GAME_NAME = "Pong - nullerino";
	private final Color BACKGROUND_COLOR = Color.WHITE;
	private final String VERSION = "0.0.0";
	private Pong game;

	public Frame()
	{
		game = new Pong();
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(GAME_NAME + " v" + VERSION);
		this.setBackground(BACKGROUND_COLOR);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(game);
	}

	public void start()
	{
		this.setVisible(true);
		game.run();
	}

	public static void main(String[] args)
	{
		Frame frame = new Frame();
		frame.start();
	}
}