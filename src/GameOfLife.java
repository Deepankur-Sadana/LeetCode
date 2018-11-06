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
		int i = 1;
		i = i<<1;
		i=i|1;
		System.out.println(i);

	}

	int[][] pre;

	public void gameOfLife(int[][] board) {

		pre = new int[board.length][board[0].length];
		
		for (int r = 0; r < pre.length; r++) {
			for (int c = 0; c < pre[0].length; c++) {
				int neighbour = getNeighbourOneSum(r, c, board);
				boolean alive = board[r][c] == 1;
				if (alive) {
					switch (neighbour) {
					case 0:
					case 1:
						pre[r][c] = 0;
						break;
					case 2:
					case 3:
						pre[r][c] = 1;
						break;
					default:
						pre[r][c] = 0;
						break;
					}

				} else {
					if (neighbour == 3)
						pre[r][c] = 1;
				}

			}
		}
		copy(board);
	}
	
	void copy(int[][]board){
		for (int r = 0; r < pre.length; r++) {
			for (int c = 0; c < pre[0].length; c++) {
				board[r][c]=pre[r][c];
			}}
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
			if (matrix[nr][nc] == 1)
				++sum;
		}

		return sum;
	}

}
