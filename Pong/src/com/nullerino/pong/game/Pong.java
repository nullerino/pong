package com.nullerino.pong.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nullerino.pong.game.ball.Ball;
import com.nullerino.pong.game.paddle.Paddle;

public class Pong extends JPanel implements KeyListener, MouseMotionListener
{
	private Graphics g;
	private int WIDTH;
	private int HEIGHT;
	private int mouseX;
	private int mouseY;
	private JLabel scoresLabel;
	private Paddle playerPaddle;
	private Paddle aiPaddle;
	private Ball ball;
	private int ticks;
	private int fps;
	long lastTime;

	/**
	 * @param width
	 * @param height
	 */
	public Pong(int width, int height)
	{
		this.addKeyListener(this);
		this.addMouseMotionListener(this);
		this.WIDTH = width;
		this.HEIGHT = height;
		scoresLabel = new JLabel();
		this.add(scoresLabel);
		ticks = 0;
		fps = 0;
		playerPaddle = new Paddle(this.WIDTH, this.HEIGHT, true);
		aiPaddle = new Paddle(this.WIDTH, this.HEIGHT, false);
		ball = new Ball(this.WIDTH, this.HEIGHT);
		lastTime = System.currentTimeMillis();
	}

	/**
	 * 
	 */
	public void tick()
	{
		ticks++;
		playerPaddle.setyPos(mouseY);
	}

	/**
	 * 
	 */
	public void render()
	{
		fps++;
		while (System.currentTimeMillis() - lastTime > 1000)
		{
			lastTime += 1000;
			fps = 0;
		}
		this.repaint();
	}

	/**
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		updatePaddles(g2d);
		updateBall(g2d);
		updateScoresLabel(g2d);
	}

	/**
	 * @param g2d
	 */
	private void updatePaddles(Graphics2D g2d)
	{
		g2d.drawRect(playerPaddle.getxPos(), playerPaddle.getyPos(),
		    Paddle.getPaddleWidth(), Paddle.getPaddleHeight());

	}

	/**
	 * @param g2d
	 */
	private void updateBall(Graphics2D g2d)
	{
		g2d.drawOval(ball.getBallX(), ball.getBallY(), Ball.getBallRad(),
		    Ball.getBallRad());
	}

	/**
	 * @param g2d
	 */
	private void updateScoresLabel(Graphics2D g2d)
	{
		scoresLabel.setText(String.valueOf(playerPaddle.getScore()) + " - "
		    + String.valueOf(aiPaddle.getScore()));
	}

	/**
	 * @param e
	 */
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * @param e
	 */
	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * @param e
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		mouseY = e.getY();
		mouseX = e.getX();
	}

	/**
	 * @param e
	 */
	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseY = e.getY();
		mouseX = e.getX();
	}

}
