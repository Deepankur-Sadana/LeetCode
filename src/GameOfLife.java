/**
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia
 * article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population. Any live cell with two or three live neighbors lives on to
 * the next generation. Any live cell with more than three live neighbors dies,
 * as if by over-population..
 * 
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by
 * reproduction.
 * 
 * Write a function to compute the next state (after one update) of the board
 * given its current state. The next state is created by applying the above
 * rules simultaneously to every cell in the current state, where births and
 * deaths occur simultaneously.
 *
 * 
 */
public class GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void gameOfLife(int[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				int neighbour = getNeighbourOneSum(r, c, board);
				boolean alive = (board[r][c] & 1) == 1;
				if (alive) {
					switch (neighbour) {
					case 0:
					case 1:
						save(false, r, c, board);
						break;
					case 2:
					case 3:
						save(true, r, c, board);
						break;
					default:
						save(false, r, c, board);
						break;
					}
				} else {
					if (neighbour == 3)
						save(true, r, c, board);
				}

			}
		}

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				board[r][c] = board[r][c] >> 1;
			}
		}
	}

	void save(boolean one, int r, int c, int[][] matrix) {
		int res = one ? 1 : 0;
		res = res << 1;
		matrix[r][c] = matrix[r][c] | res;
	}

	int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, 1 },
			{ 1, -1 } };

	int getNeighbourOneSum(int r, int c, int[][] matrix) {
		int sum = 0;
		for (int[] dir : directions) {
			int nr = r + dir[0];
			int nc = c + dir[1];
			if (nr < 0 || nr >= matrix.length || nc < 0 || nc >= matrix[0].length)
				continue;
			if ((matrix[nr][nc] & 1) == 1)
				++sum;
		}
		return sum;
	}

}
