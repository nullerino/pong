package com.nullerino.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.nullerino.pong.game.ai.AI;
import com.nullerino.pong.game.ball.Ball;
import com.nullerino.pong.game.paddle.Paddle;
import com.nullerino.pong.gui.PongWindow;

public class Pong extends JPanel implements KeyListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;

	private int WIDTH;
	private int HEIGHT;
	private int mouseX;
	private int mouseY;

	private JLabel scoresLabel;
	private Paddle playerPaddle;
	private Paddle aiPaddle;
	private AI ai;
	private Ball ball;
	private int ticks;
	private int fps;
	long lastTime;
	private final PongWindow window;
	private static final int pointsToWin = 99999;

	/**
	 * @param width
	 * @param height
	 */
	public Pong(int width, int height, PongWindow window)
	{
		this.addKeyListener(this);
		this.addMouseMotionListener(this);
		this.WIDTH = width;
		this.HEIGHT = height;
		this.window = window;
		scoresLabel = new JLabel();
		this.add(scoresLabel);
		ticks = 0;
		fps = 0;
		playerPaddle = new Paddle(this.WIDTH, this.HEIGHT, true);
		aiPaddle = new Paddle(this.WIDTH, this.HEIGHT, false);
		ai = new AI(aiPaddle);
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
		if (ticks % 128000 == 0)
		{
			ball.update();
			ai.play(generateXFinalPos());
			checkForCollision();
			checkForPointScored();
		}
	}

	private int generateXFinalPos()
	{
		return 0;
	}

	private void checkForCollision()
	{
		if (ball.getBallY() > playerPaddle.getyPos()
		    && ball.getBallY() < playerPaddle.getyPos() + Paddle.getPaddleHeight())
		{
			if (ball.getBallX() < (playerPaddle.getxPos() + Paddle.getPaddleWidth()))
			{
				ball.deflect();
				ball.setBallX(playerPaddle.getxPos() + Paddle.getPaddleWidth());
			}
		}
		else if (ball.getBallY() > aiPaddle.getyPos()
		    && ball.getBallY() < aiPaddle.getyPos() + Paddle.getPaddleHeight())
		{
			if (ball.getBallX() > (aiPaddle.getxPos() - Paddle.getPaddleWidth()))
			{
				ball.deflect();
				ball.setBallX(aiPaddle.getxPos() - Paddle.getPaddleWidth());
			}
		}

	}

	private void checkForPointScored()
	{
		if (ball.getBallX() < playerPaddle.getxPos())
		{
			// ai scores
			ball.reset();
			aiPaddle.increaseScore();
		}
		else if (ball.getBallX() > aiPaddle.getxPos())
		{
			// player scores
			ball.reset();
			playerPaddle.increaseScore();
		}

		if (playerPaddle.getScore() == pointsToWin
		    || aiPaddle.getScore() == pointsToWin)
		{
			JOptionPane.showMessageDialog(this, "Winner!");
			System.exit(0);
		}
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
		g2d.setColor(Color.RED);

		g2d.fillRect(playerPaddle.getxPos(), playerPaddle.getyPos(),
		    Paddle.getPaddleWidth(), Paddle.getPaddleHeight());

		g2d.fillRect(aiPaddle.getxPos(), aiPaddle.getyPos(),
		    Paddle.getPaddleWidth(), Paddle.getPaddleHeight());

	}

	/**
	 * @param g2d
	 */
	private void updateBall(Graphics2D g2d)
	{
		g2d.setColor(Color.BLACK);
		g2d.fillRect(ball.getBallX(), ball.getBallY(), Ball.getBallRad(),
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
	}

	/**
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
	}

	/**
	 * @param e
	 */
	@Override
	public void keyReleased(KeyEvent e)
	{
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
