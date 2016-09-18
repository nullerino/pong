package com.nullerino.paddle;

public class Paddle
{

	private boolean player;
	private int xPos;
	private int yPos;
	private int HEIGHT;
	private int WIDTH;
	private int gameWidth;
	private int gameHeight;

	public Paddle(boolean isPlayer, int gameWidth, int gameHeight)
	{
		this.player = isPlayer;
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		HEIGHT = gameHeight / 5;
		WIDTH = gameWidth / 40;
	}

	/**
	 * Set the side of the paddle
	 * 
	 * @param side
	 *          (0 - left, 1 - right)
	 */
	public void setSide(int side)
	{

	}

	public int getxPos()
	{
		return xPos;
	}

	public int getyPos()
	{
		return yPos;
	}

	public void calculateYPos(int yPos)
	{
		this.yPos = yPos - (HEIGHT / 2);
		if (this.yPos <= 0)
		{
			this.yPos = 0;
		}
		else if ((this.yPos + (HEIGHT)) >= this.gameHeight)
		{
			this.yPos = this.gameHeight - HEIGHT;
		}
//		System.out.println(this.yPos);
	}

	public int getHEIGHT()
	{
		return HEIGHT;
	}

	public int getWIDTH()
	{
		return WIDTH;
	}

}
