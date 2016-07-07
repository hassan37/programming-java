package ch3FundamentalDataStructures;

import java.util.Arrays;

public class Scoreboard {

	private int totEntries;
	private GameEntry[] board;

	public Scoreboard(int capacity) {
		board = new GameEntry[capacity];
	}

	public void addNewEntry(final GameEntry e) {
		if (totEntries < board.length || e.getScore() > board[totEntries - 1].getScore()) {
			if (totEntries < board.length)
				totEntries++;

			int i = totEntries - 1;
			while (i > 0 && e.getScore() > board[i - 1].getScore()) {
				board[i] = board[i-1];
				i--;
			}
			board[i] = e;
		}
	}

	public GameEntry removeEntry(int i) {
		GameEntry e = null;
		if (i < 0 || i >= board.length) {
			throw new IndexOutOfBoundsException("Index is out of bound.");
		}
		e = board[i];
		while (i+1 < totEntries && null != board[i+1]) {
			board[i] = board[i + 1];
			i++;
		}
		board[i] = null;
		totEntries--;

		return e;
	}

	@Override
	public String toString() {
		return "Scoreboard{" +
				"totEntries=" + totEntries +
				", board=" + Arrays.toString(board) +
				'}';
	}
}