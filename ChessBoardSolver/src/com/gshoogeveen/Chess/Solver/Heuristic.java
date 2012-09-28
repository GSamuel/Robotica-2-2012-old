package com.gshoogeveen.Chess.Solver;

import com.gshoogeveen.Chess.Board.Board;

public class Heuristic
{
	public Heuristic()
	{
		
	}
	
	public int getBoardScore(Board board)
	{
		return board.getTotalPoints();
	}
}
