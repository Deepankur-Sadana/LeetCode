
public class LeetCodeApplication {

	public static void main(String[] args) {

	}

	//#72 Edit Distance
	public int minDistance(String word1, String word2) {
		int dp[][] = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i < dp.length; i++)
			dp[i][0] = i;

		for (int i = 0; i < dp[0].length; i++)
			dp[0][i] = i;

		for (int r = 1; r < dp.length; r++) {
			for (int c = 1; c < dp[0].length; c++) {
				if (word1.charAt(r-1) == word2.charAt(c-1))
					dp[r][c] = dp[r - 1][c - 1];
				else {
					int min = Math.min(dp[r - 1][c - 1], dp[r][c - 1]);
					min = Math.min(min, dp[r - 1][c]);
					dp[r][c] = min +1;
				}
			}
		}

		return dp[word1.length()][word2.length()];
	}
}
