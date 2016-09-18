package com.nullerino.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nullerino.gui.Board;
import com.nullerino.paddle.Paddle;

public class Pong extends JPanel implements Runnable, KeyListener
{

	private final int TICK_RATE = 128;
	private final int TICK_RATE_MS = 1000 / TICK_RATE;
	private boolean running;
	private boolean paused;
	private long curTime;
	private long lastUpdate;
	private int ticks;
	private Board board;
	private Paddle playerPaddle;
	private Paddle aiPaddle;

	public Pong()
	{
		running = true;
		paused = false;
		curTime = 0;
		ticks = 0;
		lastUpdate = 0;
		// TODO set up board and paddles
		this.addKeyListener(this); // TODO fix issue with this not working
		this.add(new JLabel("tester"));
	}

	public void run()
	{
		while (running == true)
		{
			if (paused == false)
			{
				curTime = System.currentTimeMillis();
				if ((curTime - lastUpdate) > TICK_RATE_MS)
				{
					// TODO update
					++ticks;
					// System.out
					// .println("Tick: " + ticks + "\nDiff: " + (curTime - lastUpdate));
					lastUpdate = System.currentTimeMillis();
				}
			}
		}
	}

	private void pause()
	{
		if (paused == true)
		{
			// TODO open pause menu
			paused = false;
		}
		else if (paused == false)
		{
			// TODO close pause menu
			paused = true;
			System.out.println("Game paused..");
		}
	}

	public void keyTyped(KeyEvent e)
	{
		System.out.println(e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			pause();
		}
	}

	public void keyReleased(KeyEvent e)
	{
		System.out.println(e.getKeyCode());
	}

}