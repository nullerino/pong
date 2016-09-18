package com.nullerino.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Board extends JPanel implements MouseMotionListener
{

	private int mouseX;
	private int mouseY;
	
	public Board()
	{
		this.mouseX = 0;
		this.mouseY = 0;
		this.addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

}
