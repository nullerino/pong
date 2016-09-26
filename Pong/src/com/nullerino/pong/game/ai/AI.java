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
		ballYFinalPos -= Paddle.getPaddleHeight() / 2;
		if (ballYFinalPos < paddle.getyPos())
		{
			paddle.setyPos((paddle.getyPos() - delta) + (Paddle.getPaddleHeight() / 2));
		}
		else if (ballYFinalPos > paddle.getyPos())
		{
			paddle.setyPos((paddle.getyPos() + delta) + (Paddle.getPaddleHeight() / 2));
		}
	}
	
	public static int getDelta()
	{
		return delta;
	}
}
