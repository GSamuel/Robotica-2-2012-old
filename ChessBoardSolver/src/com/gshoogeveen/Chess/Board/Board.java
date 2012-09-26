package com.gshoogeveen.Chess.Board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.ListIterator;

import com.gshoogeveen.Chess.pieces.King;
import com.gshoogeveen.Chess.pieces.Pawn;
import com.gshoogeveen.Chess.pieces.Piece;
import com.gshoogeveen.Chess.pieces.Team;

public class Board
{
	ArrayList<Piece> allPieces;
	private Team turn = Team.WHITE;

	public Board()
	{
		init();
	}

	public Board(ArrayList<Piece> allPieces, Team turn)
	{
		this.allPieces = allPieces;
		this.turn = turn;
	}

	private void init()
	{
		allPieces = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++)
		{
			allPieces.add(new Pawn(Team.WHITE, new Point(i, 1)));
			allPieces.add(new Pawn(Team.BLACK, new Point(i, 6)));
		}
		allPieces.add(new King(Team.WHITE, new Point(4, 0)));
		allPieces.add(new King(Team.BLACK, new Point(4, 7)));
	}

	public boolean pieceOnPos(int x, int y)
	{
		ListIterator<Piece> it = allPieces.listIterator();
		Piece temp = null;
		while (it.hasNext())
		{
			temp = it.next();
			if (temp.isOnPos(new Point(x, y)))
				return true;
		}
		return false;
	}

	public Piece getPieceOnPos(int x, int y)
	{
		ListIterator<Piece> it = allPieces.listIterator();
		Piece temp = null;
		while (it.hasNext())
		{
			temp = it.next();
			if (temp.isOnPos(new Point(x, y)))
				return temp;
		}
		return null;
	}

	public boolean onBoard(int x, int y)
	{
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}

	public Board move(Move m)
	{
		ListIterator<Piece> it = allPieces.listIterator();
		Piece temp = null, newPiece = null;
		while (it.hasNext())
		{
			temp = it.next();
			if (temp.isOnPos(m.getTo()))
				it.remove();
			else if (temp.isOnPos(m.getFrom()))
			{
				it.remove();
				newPiece = temp.clone();
				newPiece.moveTo(m.getTo());
			}
		}
		if (newPiece != null)
			allPieces.add(newPiece);

		turn = turn.getOther();
		
		return this;
	}

	public ArrayList<Move> getAllMoves(Team team)
	{
		ArrayList<Move> moves = new ArrayList<Move>();

		ListIterator<Piece> it = allPieces.listIterator();
		Piece temp = null;
		while (it.hasNext())
		{
			temp = it.next();
			if (temp.isTeam(team))
				moves.addAll(temp.getAllMoves(this));
		}
		return moves;
	}

	public Team getTurn()
	{
		return turn;
	}

	public String toString()
	{
		String s = "" + allPieces;
		s += "\n" + allPieces.get(17).getAllMoves(this);
		// s += "\n"+pawn.getAllMoves(this).toString();
		return s;
	}

	public String displayBoard()
	{
		String s = "";
		Piece temp;
		for (int i = 7; i >= 0; i--)
		{
			for (int j = 0; j < 8; j++)
			{
				temp = getPieceOnPos(j, i);
				if (temp != null)
				{
					s += "[" + temp.getChar() + "]";
				} else
				{
					s += "[ ]";
				}
			}
			s += "\n";
		}
		s += "\n" + getAllMoves(turn) + "\n";
		return s;
	}

	public Board clone()
	{
		return new Board((ArrayList<Piece>) allPieces.clone(), turn);
	}
}
