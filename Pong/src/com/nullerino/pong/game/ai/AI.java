package com.nullerino.pong.game.ai;

import com.nullerino.pong.game.paddle.Paddle;

public class AI
{

	private Paddle paddle;
	private static final int delta = 2;

	public AI(Paddle paddle)
	{
		this.paddle = paddle;
	}

	public void play(int ballYFinalPos)
	{
		if (ballYFinalPos < paddle.getyPos())
		{

		}
		else if (ballYFinalPos > paddle.getyPos())
		{

		}
	}

}
