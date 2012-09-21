package com.gshoogeveen.Chess.pieces;

import java.awt.Point;
import java.util.ArrayList;

import com.gshoogeveen.Chess.Board.Board;

public abstract class Piece
{
	private Team team;
	private int x,y;

	public Piece(Team team, int x, int y)
	{
		this.team = team;
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public boolean isOnPos(int x,int y)
	{
		return this.x == x && this.y == y;
	}
	
	public abstract ArrayList<Point> getAllMoves(Board board);
}
