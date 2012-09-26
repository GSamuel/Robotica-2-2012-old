package com.gshoogeveen.Chess.pieces;

import java.awt.Point;
import java.util.ArrayList;

import com.gshoogeveen.Chess.Board.Board;
import com.gshoogeveen.Chess.Board.Move;

public class King extends Piece
{
	public static int value = 10;

	public King(Team team, Point pos)
	{
		super(team, pos);
	}

	@Override
	public ArrayList<Move> getAllMoves(Board board)
	{
		ArrayList<Move> moves = new ArrayList<Move>();
		for (int i = -1; i < 2; i++)
			for (int j = -1; j < 2; j++)
			{
				if (canAttackOrMove(pos.x + i, pos.y + j, board))
					moves.add(new Move(new Point(pos.x, pos.y), new Point(pos.x + i, pos.y + j)));
			}
		return moves;
	}

	@Override
	public String getName()
	{
		return "King";
	}

	@Override
	public int getValue()
	{
		return value;
	}

	public char getChar()
	{
		if (team == Team.BLACK)
			return 'k';
		else
			return 'K';
	}
	
	public King clone()
	{
		return new King(team, pos);
	}

}
