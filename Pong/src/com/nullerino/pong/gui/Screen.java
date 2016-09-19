package com.nullerino.pong.gui;

public class Screen
{

	private final int		WIDTH;
	private final int		HEIGHT;
	private final int[]	pixels;

	public Screen(int WIDTH, int HEIGHT)
	{
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.pixels = new int[WIDTH * HEIGHT];
	}
}
