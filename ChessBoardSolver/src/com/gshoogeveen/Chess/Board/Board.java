package com.gshoogeveen.Chess.Board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.ListIterator;

import com.gshoogeveen.Chess.pieces.Pawn;
import com.gshoogeveen.Chess.pieces.Piece;
import com.gshoogeveen.Chess.pieces.Team;

public class Board
{
	ArrayList<Piece> allPieces;

	public Board()
	{
		init();
	}
	
	private void init()
	{
		allPieces = new ArrayList<Piece>();
		for(int i = 0; i<8; i ++)
		{
			allPieces.add(new Pawn(Team.WHITE, new Point (i,1)));
			allPieces.add(new Pawn(Team.BLACK, new Point (i,6)));
		}

		allPieces.add(new Pawn(Team.BLACK, new Point (1,2)));
	}

	public boolean pieceOnPos(int x, int y)
	{
		ListIterator<Piece> it = allPieces.listIterator();
		Piece temp = null;
		while (it.hasNext())
		{
			temp = it.next();
			if (temp.isOnPos(new Point(x,y)))
				return true;
		}
		return false;
	}
	
	public Piece getPieceOnPos(int x,int y)
	{
		ListIterator<Piece> it = allPieces.listIterator();
		Piece temp = null;
		while (it.hasNext())
		{
			temp = it.next();
			if (temp.isOnPos(new Point(x,y)))
				return temp;
		}
		return null;
	}

	public boolean onBoard(int x, int y)
	{
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}
	
	public String toString()
	{
		String s = ""+allPieces;
		s += "\n"+allPieces.get(0).getAllMoves(this);
		//s += "\n"+pawn.getAllMoves(this).toString();
		return s;
	}
}
