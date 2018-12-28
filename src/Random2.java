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

				dp[r][c] = A[r][c] + Math.min(mina, Math.min(minb, minc));
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A[0].length; i++)
			min = Math.min(min, dp[dp.length - 1][i]);
		return min;
	}

	// #773. Sliding Puzzle
	public static int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	private Queue<String> q = new LinkedList<>();

	public int slidingPuzzle(int[][] board) {
		HashSet<String> seen = new HashSet<>(); // used to avoid duplicates
		final String target = "123450";
		int moves = 0;
		String start = getStringRepresentation(board);
		if (start.equals(target))
			return 0;
		q.add(start);
		while (!q.isEmpty()) {
			String poll = q.poll();
			if (poll.equals(target))
				return moves;
			moves++;
			List<String> list = getPossibleStates(poll, board);
			for (String s : list) {
				boolean insert = seen.add(s);
				if (!insert)
					continue;
				if (s.equals(target))
					return moves;
				q.add(s);
			}
			moves++;
		}
		return moves;
	}

	List<String> getPossibleStates(String state, int[][] board) {
		int[][] arr = new int[board.length][board[0].length];
		int index = 0;
		int r0 = 0, c0 = 0;
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				arr[r][c] = state.toCharArray()[index++];
				if (arr[r][c] == 0) {
					r0 = r;
					c0 = c;
				}
			}
		}
		ArrayList<int[]> pointList = new ArrayList<int[]>();

		for (int[] dir : directions) {
			int r = r0 + dir[0];
			int c = c0 + dir[1];
			if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
				continue;
			pointList.add(new int[] { r, c });
		}

		ArrayList<String> nextMove = new ArrayList<>();
		for (int[] point : pointList) {
			swap(arr, new int[] { r0, c0 }, point);
			nextMove.add(getStringRepresentation(arr));
			swap(arr, new int[] { r0, c0 }, point);
		}
		return nextMove;
	}

	void swap(int arr[][], int[] pointA, int[] pointB) {
		int temp = arr[pointA[0]][pointA[1]];
		arr[pointA[0]][pointA[1]] = arr[pointB[0]][pointB[1]];
		arr[pointB[0]][pointB[1]] = temp;
	}

	String getStringRepresentation(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				sb.append(arr[r][c]);
			}
		}
		return sb.toString();
	}

	public static void main(String[] s) {
		int sum = new Random2().addAmount("Ciggi 150\n" + 
				"Auto 150\n" + 
				"Biryani 100\n" + 
				"Showarma kebab 400\n" + 
				"230 food bus\n" + 
				"1100 booze cab\n" + 
				"500 avaneesh token cash\n" + 
				"250 pizza 1st day\n" + 
				"200 1st day ciggi\n" + 
				"470 auto\n" + 
				"585 beer \n" + 
				"Food biryani189\n" + 
				"Cab 430\n" + 
				"1000 drinks\n" + 
				"300 food\n" + 
				"160 ciggi\n" + 
				"1213 sky high\n" + 
				"120 ciggi\n" + 
				"470 cab day 3\n" + 
				"320 cab day 3\n" + 
				"100 tickets museums\n" + 
				"200 pondi food.\n" + 
				"662 harshit ola");
		System.out.println(sum);
		
	}

	// #213. House Robber II
	public int rob(int[] nums) {
		int count = nums.length;
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);

		return Math.max(rob(nums, 0, count - 1), rob(nums, 1, count));
	}

	// l inclusive ; h exclusive
	int rob(int[] nums, int l, int h) {

		int dp[] = new int[nums.length];
		dp[l] = nums[l];
		dp[l + 1] = Math.max(nums[l], nums[l + 1]);

		for (int i = l + 2; i < h; i++) {
			if (l == 0)
				dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
			else
				dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[dp.length - (l == 0 ? 2 : 1)];
	}

	// #729 My Calendar I
	public boolean book(int start, int end) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
//    	Long key = 42l;
		Map.Entry<Integer, Integer> low = map.floorEntry(start);
		Map.Entry<Integer, Integer> high = map.ceilingEntry(end);
		Object res = null;
		if (low != null && high != null) {
			res = Math.abs(key - low.getKey()) < Math.abs(key - high.getKey()) ? low.getValue() : high.getValue();
		} else if (low != null || high != null) {
			res = low != null ? low.getValue() : high.getValue();
		}
		return false;
	}

	int addAmount(String s) {
		char arr[] = s.toCharArray();
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i])) {
				sb.append(arr[i]);
			} else {
				if (sb.length() != 0) {
					int c = Integer.parseInt(sb.toString());
					sb.setLength(0);
					sum += c;
				}
			}
		}
		return sum;
	}

}
