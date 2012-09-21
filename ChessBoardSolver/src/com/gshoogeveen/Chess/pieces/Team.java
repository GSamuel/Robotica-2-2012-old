package com.gshoogeveen.Chess.pieces;


public enum Team
{
	WHITE, BLACK;
	
	public Team getOther(Team team)
	{
		if (team == WHITE)
			return BLACK;
		return WHITE;
	}
	
	public Team getOther()
	{
		return getOther(this);
	}
}
