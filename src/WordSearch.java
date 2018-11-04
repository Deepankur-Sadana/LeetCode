
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

	// #661 Image smoother
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
				if (count != 0)
					res[r][c] = sum / count;
			}
		}
		return res;
	}

	// #73 set-matrix-zeroes/
	public void setZeroes(int[][] matrix) {
		boolean col_0 = false// set first col to 0
				, row_0 = false;// set first row to 0

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				col_0 = true;
				break;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				row_0 = true;
				break;
			}
		}

		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				if (matrix[r][c] == 0) {
					matrix[r][0] = 0;
					matrix[0][c] = 0;
				}
			}
		}

		for (int r = 1; r < matrix.length; r++) {
			if (matrix[r][0] == 0)
				nulliFyRow(r, matrix);
		}
		for (int c = 1; c < matrix[0].length; c++) {
			if (matrix[0][c] == 0)
				nulliFyCol(c, matrix);
		}

		if (col_0)
			nulliFyCol(0, matrix);

		if (row_0)
			nulliFyRow(0, matrix);

	}

	void nulliFyRow(int row, int[][] matrix) {
		for (int c = 0; c < matrix[row].length; c++) {
			matrix[row][c] = 0;
		}
	}

	void nulliFyCol(int col, int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			matrix[r][col] = 0;
		}
	}

	int M = Integer.MIN_VALUE, sM = Integer.MIN_VALUE, tM = Integer.MIN_VALUE;
	boolean MIN;

	public int thirdMax(int[] nums) {
		M = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num == Integer.MIN_VALUE)
				MIN = true;
			if (num > M) {

			} else if (num < M && num > sM) {

			} else if (num < sM && num > tM) {

			}

		}
	}

	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, len = 0;
		for (int n : nums) {
			if (n == 1)
				++len;
			else {
				if (len > max)
					max = len;
				len = 0;
			}
		}
		return Math.max(max, len);
	}
}
