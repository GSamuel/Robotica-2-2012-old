package com.gshoogeveen.Chess.pieces;

import java.awt.Point;
import java.util.ArrayList;

import com.gshoogeveen.Chess.Board.Board;
import com.gshoogeveen.Chess.Board.Move;

public class Pawn extends Piece
{
	public static int value = 1;
	
	public Pawn(Team team, Point pos)
	{
		super(team, pos);
	}

	@Override
	public ArrayList<Move> getAllMoves(Board board)
	{
		ArrayList<Move> moves = new ArrayList<Move>();
		int tempY,tempX, devY;
		
		if(team == Team.BLACK)
			devY = -1;
		else
			devY = 1;
		tempY = pos.y + devY;
		
		if(canMove(pos.x, tempY, board))
		{
			moves.add(new Move(new Point(pos.x,pos.y),new Point(pos.x, tempY)));
			if(!this.hasMoved())
			{
				tempY += devY;
				if(canMove(pos.x, tempY, board))
				{
					moves.add(new Move(new Point(pos.x,pos.y),new Point(pos.x, tempY)));
				}
			}
			
		}

		tempY = pos.y + devY;
		tempX = pos.x - 1;
		if(canAttack(tempX, tempY, board))
			moves.add(new Move(new Point(pos.x,pos.y),new Point(tempX, tempY)));

		tempX = pos.x + 1;
		if(canAttack(tempX, tempY, board))
			moves.add(new Move(new Point(pos.x,pos.y),new Point(tempX, tempY)));
		
		return moves;
	}
	public String getName()
	{
		return "Pawn";
	}

	@Override
	public int getValue()
	{
		return value;
	}

}
