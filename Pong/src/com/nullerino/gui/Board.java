package com.nullerino.gui;

import javax.swing.JPanel;

import com.nullerino.paddle.Paddle;

public class Board extends JPanel
{

	private Paddle playerPaddle;
	private Paddle aiPaddle;
	private int gameWidth;
	private int gameHeight;

	public Board(int gameWidth, int gameHeight)
	{
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		playerPaddle = new Paddle(true, gameWidth, gameHeight);
		aiPaddle = new Paddle(false, gameWidth, gameHeight);
	}

	public Paddle getPlayerPaddle()
	{
		return playerPaddle;
	}

}
