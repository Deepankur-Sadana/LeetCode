
public class WordSearch {

	int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {

	}

	boolean used[][];

	// #79 word search
	public boolean exist(char[][] board, String word) {
		used = new boolean[board.length][board[0].length];
		return dfs(board, word.toCharArray(), 0, 0, 0);
	}

	boolean dfs(char[][] board, char[] w, int index, int r, int c) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
			return false;

		if (used[r][c])
			return false;

		if (board[r][c] != w[index])
			return false;

		if (index == w.length)
			return true;

		if (w[index] == board[r][c]) {
			for (int[] dir : directions) {

			}

		}

	}

	int[][] AllDirections = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 },

			{ -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

	//#661 Image smoother
	public int[][] imageSmoother(int[][] M) {
		int[][] res = new int[M.length][M[0].length];

		for (int r = 0; r < M.length; r++) {
			for (int c = 0; c < M[0].length; c++) {

				int sum = M[r][c], count = 1;
				
				for (int[] dir : AllDirections) {
					int x = r + dir[0], y = c + dir[1];
					if (x < 0 || x >= M.length || y < 0 || y >= M[0].length)
						continue;
					sum += M[x][y];
					count++;
				}
				if(count != 0)
				res[r][c] = sum / count;
			}
		}
		return res;
	}

}
