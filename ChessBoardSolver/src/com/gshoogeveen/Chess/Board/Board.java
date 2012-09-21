package com.gshoogeveen.Chess.Board;
import java.util.ArrayList;
import java.util.ListIterator;

import com.gshoogeveen.Chess.pieces.Pawn;
import com.gshoogeveen.Chess.pieces.Piece;
import com.gshoogeveen.Chess.pieces.Team;

public class Board
{
	ArrayList<Piece> allPieces = new ArrayList<Piece>();

	public Board()
	{
		allPieces.add(new Pawn(Team.WHITE, 0,0));
	}
	
	public boolean pieceOnPos(int x, int y)
	{
		ListIterator<Piece>it = allPieces.listIterator();
		Piece temp = null;
		while(it.hasNext())
		{
			temp = it.next();
			if(temp.isOnPos(x, y))
				return true;
		}
		return false;
	}
}
