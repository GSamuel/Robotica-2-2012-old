package com.gshoogeveen.Chess.Board;

import java.awt.Point;

public class Move
{
	private Point from, to;
	public Move(Point from, Point to)
	{
		this.from = from;
		this.to = to;
	}
	
	public Point getFrom()
	{
		return from;
	}
	
	public Point getTo()
	{
		return to;
	}
	
	public String toString()
	{
		return ""+(char)(from.x+97)+(from.y+1)+"-"+(char)(to.x+97)+(to.y+1);
	}
}
