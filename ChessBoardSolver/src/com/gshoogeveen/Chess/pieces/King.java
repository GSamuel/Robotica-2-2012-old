package com.gshoogeveen.Chess.pieces;

import java.awt.Point;
import java.util.ArrayList;

import com.gshoogeveen.Chess.Board.Board;

public class King extends Piece
{

	public King(Team team, Point pos)
	{
		super(team, pos);
	}

	@Override
	public ArrayList<Point> getAllMoves(Board board)
	{
		ArrayList<Point> points = new ArrayList<Point>();
		for(int i = -1; i<2; i++)
			for(int j = -1; j<2; j++)
			{
				if(canAttackOrMove(pos.x+i, pos.y+j, board))
					points.add(new Point(pos.x+i,pos.y+j));
			}
		return points;
	}

	@Override
	public String getName()
	{
		return "King";
	}

}
