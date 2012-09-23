package com.gshoogeveen.Chess.pieces;

import java.awt.Point;
import java.util.ArrayList;

import com.gshoogeveen.Chess.Board.Board;
import com.gshoogeveen.Chess.Board.Move;

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
		return this.team.isTheSame(team.getOther());
	}
	
	public boolean hasMoved()
	{
		return hasMoved; 
	}
	public boolean setHasMoved(boolean bool)
	{
		return hasMoved = bool;
	}
	
	public boolean canAttack(int x, int y, Board board)
	{
		return board.pieceOnPos(x,y) && board.getPieceOnPos(x,y).isOtherTeam(team)&& board.onBoard(x, y);
	}
	
	public boolean canMove(int x, int y, Board board)
	{
		return !board.pieceOnPos(x, y) && board.onBoard(x, y);
	}
	
	public boolean canAttackOrMove(int x , int y, Board board)
	{
		return canMove(x,y,board) || canAttack(x,y,board);
	}
	
	public abstract ArrayList<Move> getAllMoves(Board board);
	public abstract String getName();
	public abstract int getValue();
	
	public String toString()
	{
		return getName()+" "+ team.toString()+" "+pos.x+" "+pos.y;
	}
}
