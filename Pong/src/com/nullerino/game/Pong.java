package com.nullerino.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import com.nullerino.gui.Board;

public class Pong extends JPanel
    implements Runnable, KeyListener, MouseMotionListener
{

	private final int TICK_RATE = 128;
	private final int TICK_RATE_MS = 1000 / TICK_RATE;
	private final int WIDTH = 1200;
	private final int HEIGHT = 900;
	private final String GAME_NAME = "Pong - nullerino";
	private final Color BACKGROUND_COLOR = Color.WHITE;
	private final String VERSION = "0.0.1";

	private boolean running;
	private boolean paused;
	private long curTime;
	private long lastUpdate;
	private int ticks;
	private Board board;
	private int mouseX;
	private int mouseY;

	public Pong()
	{
		running = true;
		paused = false;
		curTime = 0;
		ticks = 0;
		lastUpdate = 0;

		this.setBackground(BACKGROUND_COLOR);
		// TODO set up board and paddles
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		board = new Board(WIDTH, HEIGHT);
		this.add(board);
		this.addKeyListener(this);
		this.addMouseMotionListener(this);
		this.setFocusable(true);
		this.requestFocus();
	}

	public int getWIDTH()
	{
		return WIDTH;
	}

	public int getHEIGHT()
	{
		return HEIGHT;
	}

	public String getGAME_NAME()
	{
		return GAME_NAME;
	}

	public Color getBACKGROUND_COLOR()
	{
		return BACKGROUND_COLOR;
	}

	public String getVERSION()
	{
		return VERSION;
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
					repaint();
					++ticks;
					lastUpdate = System.currentTimeMillis();
				}
			}
		}
	}

	public void updatePanel(Graphics g)
	{
		g.drawRect(board.getPlayerPaddle().getxPos(),
		    board.getPlayerPaddle().getyPos(), board.getPlayerPaddle().getWIDTH(),
		    board.getPlayerPaddle().getHEIGHT());
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		updatePanel(g);
	}

	private void pause()
	{
		if (paused == false)
		{
			// TODO open pause menu
			paused = true;
			System.out.println("Game unpaused..");
		}
		else if (paused == true)
		{
			// TODO close pause menu
			paused = false;
			System.out.println("Game paused..");
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			pause();
		}
	}

	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		if (paused == false)
		{
			mouseX = e.getX();
			mouseY = e.getY();
			System.out.println(mouseY);
			board.getPlayerPaddle().calculateYPos(mouseY);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		if (paused == false)
		{
			mouseX = e.getX();
			mouseY = e.getY();
			System.out.println(mouseY);
			board.getPlayerPaddle().calculateYPos(mouseY);
		}
	}

}
