package com.nullerino.pong.game.ball;

public class Ball
{

	private int ballX;
	private int ballY;
	private double angle;
	private final int WIDTH;
	private final int HEIGHT;
	private static final int delta = 10;
	private static final int ballRad = 20;

	/**
	 * @param width
	 * @param height
	 */
	public Ball(int width, int height)
	{
		this.HEIGHT = height - 30;
		this.WIDTH = width - 8;
		angle = 10;

		ballX = width / 2;
		ballY = height / 2;
	}

	/**
	 * @return
	 */
	public int getBallX()
	{
		return ballX;
	}

	/**
	 * @param ballX
	 */
	public void setBallX(int ballX)
	{
		this.ballX = ballX;
	}

	/**
	 * @return
	 */
	public int getBallY()
	{
		return ballY;
	}

	/**
	 * @param ballY
	 */
	public void setBallY(int ballY)
	{
		this.ballY = ballY;
	}

	/**
	 * @return
	 */
	public static int getBallRad()
	{
		return ballRad;
	}

	/**
	 * @return the angle
	 */
	public double getAngle()
	{
		return angle;
	}

	/**
	 * @param angle
	 *          the angle to set
	 */
	/**
	 * @param angle
	 */
	public void setAngle(double angle)
	{
		this.angle = angle;
	}

	/**
	 * @return the delta
	 */
	/**
	 * @return
	 */
	public static int getDelta()
	{
		return delta;
	}
}
