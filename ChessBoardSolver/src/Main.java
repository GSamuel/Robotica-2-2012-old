import java.util.ArrayList;
import java.util.ListIterator;

import com.gshoogeveen.Chess.Board.Board;
import com.gshoogeveen.Chess.Board.Move;
import com.gshoogeveen.Chess.Solver.Heuristic;

public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Heuristic h = new Heuristic();

		Board board = new Board();
		System.out.println(board.displayBoard());

		for (int i = 0; i < 100; i++)
		{
			ArrayList<Move> moves = board.getAllMoves(board.getTurn());
			ListIterator<Move> it = moves.listIterator();

			Board tempB = null, highest = null;
			if (it.hasNext())
				highest = board.clone().move(it.next());
			while (it.hasNext())
			{
				tempB = board.clone().move(it.next());
				if (h.getBoardScore(tempB) > h.getBoardScore(highest))
					highest = tempB;
			}
			board = highest;
			System.out.println(board.displayBoard());
		}


	}

}
