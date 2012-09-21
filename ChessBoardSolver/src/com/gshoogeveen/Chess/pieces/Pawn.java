package com.gshoogeveen.Chess.pieces;

import java.awt.Point;
import java.util.ArrayList;

import com.gshoogeveen.Chess.Board.Board;

public class Pawn extends Piece
{
	public Pawn(Team team, Point pos)
	{
		super(team, pos);
	}

	@Override
	public ArrayList<Point> getAllMoves(Board board)
	{
		ArrayList<Point> points = new ArrayList<Point>();
		int tempY,tempX, devY;
		
		if(team == Team.BLACK)
			devY = -1;
		else
			devY = 1;
		tempY = pos.y + devY;
		
		if(canMove(pos.x, tempY, board))
		{
			points.add(new Point(pos.x, tempY));
			if(!this.hasMoved())
			{
				tempY += devY;
				if(canMove(pos.x, tempY, board))
				{
					points.add(new Point(pos.x, tempY));
				}
			}
			
		}

		tempY = pos.y + devY;
		tempX = pos.x - 1;
		if(canAttack(tempX, tempY, board))
			points.add(new Point(tempX, tempY)); 

		tempX = pos.x + 1;
		if(canAttack(tempX, tempY, board))
			points.add(new Point(tempX, tempY));
		
		return points;
	}
	public String getName()
	{
		return "Pawn";
	}

}
