import java.util.*;

public class Random2 {

	// #49. Group Anagrams
	public List<List<String>> groupAnagrams(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103 };
		HashMap<Integer, LinkedList<String>> map = new HashMap<>();

		List<List<String>> res = new ArrayList<>();
		for (String str : strs) {
			int mul = 1;
			for (char c : str.toCharArray()) {
				mul *= prime[c - 'a'];
			}
			if (map.get(mul) == null) {
				LinkedList<String> list = new LinkedList<>();
				list.add(str);
				map.put(mul, list);
				res.add(list);
			} else {
				map.get(mul).add(str);
			}
		}
		return res;
	}

	// #931. Minimum Falling Path Sum
	public int minFallingPathSum(int[][] A) {
		int dp[][] = new int[A.length][A[0].length];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = A[0][i];
		}

		for (int r = 1; r < A.length; r++) {
			for (int c = 0; c < A[0].length; c++) {
				int mina = Integer.MAX_VALUE;
				int minb = mina;
				int minc = mina;

				minb = dp[r - 1][c];

				if (c > 0)
					mina = dp[r - 1][c - 1];
				if (c < A[0].length - 1)
					minc = dp[r - 1][c + 1];

				dp[r][c] = A[r][c]+Math.min(mina, Math.min(minb, minc));
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A[0].length; i++)
			min = Math.min(min, dp[dp.length - 1][i]);
		return min;
	}

}
