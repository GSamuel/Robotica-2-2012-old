package com.gshoogeveen.Chess.pieces;

import java.awt.Point;
import java.util.ArrayList;

import com.gshoogeveen.Chess.Board.Board;

public abstract class Piece
{
	protected Team team;
	protected Point pos;
	protected boolean hasMoved = false;

	public Piece(Team team, Point pos)
	{
		this.team = team;
		this.pos = (Point) pos.clone();
	}

	public void moveTo(Point pos)
	{
		this.pos = pos;
		hasMoved = true;
	}

	public boolean isOnPos(Point pos)
	{
		return this.pos.x == pos.x && this.pos.y == pos.y;
	}
	
	public boolean isOtherTeam(Team team)
	{
		return team.compareTo(team)==0;
	}
	
	public boolean hasMoved()
	{
		return hasMoved;
	}
	
	public abstract ArrayList<Point> getAllMoves(Board board);
}
