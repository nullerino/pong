package com.nullerino.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class Pong extends JPanel
{

	private int[][]		pixels;
	private Graphics	g;
	private int				WIDTH;
	private int				HEIGHT;

	public Pong(int width, int height)
	{
		this.WIDTH = width;
		this.HEIGHT = height;
		pixels = new int[width][height];
	}

	public void tick()
	{

	}

	public void render()
	{
		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Random random = new Random();
		Graphics2D g2d = (Graphics2D) g;
		for (int ii = 0; ii < WIDTH; ++ii)
		{
			for (int jj = 0; jj < HEIGHT; ++jj)
			{
				pixels[ii][jj] = random.nextInt();
				g2d.setColor(new Color(pixels[ii][jj]));
				g2d.drawRect(ii, jj, 1, 1);
			}
		}
	}

}
