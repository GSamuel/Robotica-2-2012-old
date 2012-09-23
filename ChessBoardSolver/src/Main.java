import java.awt.Point;

import com.gshoogeveen.Chess.Board.Board;
import com.gshoogeveen.Chess.Board.Move;


public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Board board = new Board();
		System.out.println(board.displayBoard());
		board.move(new Move(new Point(0,1), new Point(0,3)));
		System.out.println(board.displayBoard());

	}

}
