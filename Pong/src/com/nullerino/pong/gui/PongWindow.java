package com.nullerino.pong.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class PongWindow extends JFrame implements Runnable
{

	private static final int		WIDTH					= 1280;
	private static final int		HEIGHT				= (WIDTH / 16) * 9;

	private static final String	GAME_NAME			= "Pong - nullerino";
	private static final String	GAME_VERSION	= "0.0.0";

	private boolean							running;
	private Thread							gameThread;

	private Screen							screen;

	public PongWindow()
	{
		Dimension size = new Dimension(WIDTH, HEIGHT);
		this.setTitle(GAME_NAME + " v" + GAME_VERSION);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		screen = new Screen(WIDTH, HEIGHT);
	}

	public synchronized void start()
	{
		if (running == false)
		{
			running = true;
			gameThread = new Thread(this);
			gameThread.start();
		}
	}

	public synchronized void stop()
	{
		if (running == true)
		{
			running = false;
			try
			{
				gameThread.join();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		PongWindow window = new PongWindow();
		window.pack();
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.start();
	}

	@Override
	public void run()
	{
		while (running == true)
		{
			tick();
			render();
		}
	}

	private void tick()
	{
	}

	private void render()
	{
	}

}
