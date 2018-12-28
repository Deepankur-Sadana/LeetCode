import java.util.*;

public class Sample {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, -3 };
		System.out.println(firstMissingPositiveNumber(arr));

	}

	public static int firstMissingPositiveNumber(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] > 0 && arr[i] <= len) {
				if (arr[i] - 1 != i && arr[arr[i] - 1] != arr[i]) {
					int temp = arr[arr[i] - 1];
					arr[arr[i] - 1] = arr[i];
					arr[i] = temp;
					i--;
				}
			}
		}
		Utils.print(arr);
		for (int i = 0; i < len; i++)
			if (arr[i] != i + 1)
				return i + 1;
		return len + 1;
	}

	public char findTheDifference(String s, String t) {
		int sum = 0;
		for (char c : t.toCharArray()) {
			sum += c;
		}

		for (char c : s.toCharArray()) {
			sum -= c;
		}

		return (char) sum;
	}

	// #11 container-with-most-water/
	public int maxArea(int[] height) {
		int i = 0, j = height.length - 1;
		int max = 0;
		while (i < j) {
			int diff = j - i;
			int water = Math.min(height[i], height[j]) * diff;
			if (water > max)
				max = water;
			if (height[i] > height[j]) {
				j--;
			} else if (height[i] < height[j]) {
				i++;
			} else {
				j--;
				i++;
			}
		}
		return max;
	}

	List<List<Integer>> list = new ArrayList<>();

	// 103 Binary Tree Zigzag Level Order Traversal
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		BFS(root, 0);
		return list;

	}

	void BFS(TreeNode root, int level) {
		if (root == null)
			return;
		if (list.size() == level)
			list.add(new ArrayList<>());
		list.get(level).add(root.val);
		BFS(root.left, level + 1);
		BFS(root.right, level + 1);
	}

	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length())
			return false;
		int arr[] = new int[A.length()];
		char[] cA = A.toCharArray();
		char[] cB = A.toCharArray();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < A.length(); i++) {
			arr[i] = cA[i] - cB[i];
			if (arr[i] != 0)
				list.add(arr[i]);

		}
		if (list.size() != 2)
			return false;
		return list.get(0) + list.get(1) == 0;

	}

	// 200 /number-of-islands/
	boolean marked[][];

	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;
		marked = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == '1' && !marked[r][c]) {
					traverse(r, c, grid);
					++count;
				}
			}
		}

		return count;
	}

	void traverse(int r, int c, char[][] grid) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
			return;

		if (grid[r][c] == '0' || marked[r][c])
			return;

		marked[r][c] = true;
		traverse(r + 1, c, grid);// r
		traverse(r, c + 1, grid);// bottom
		traverse(r - 1, c, grid);// l
		traverse(r, c - 1, grid);// top

	}

	int[][] P, A;
	int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };;

	// #417 pacific-atlantic-water-flow
	public List<int[]> pacificAtlantic(int[][] matrix) {
		P = new int[matrix.length][matrix[0].length];
		A = new int[matrix.length][matrix[0].length];

		dfs(matrix, A, 0, 0, 0);
		dfs(matrix, P, 0, 0, 0);

		List<int[]> list = new ArrayList<>();
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				if (P[r][c] == 1 && A[r][c] == 1)
					list.add(new int[] { r, c });
			}
		}
		return list;
	}

	private void dfs(int[][] matrix, int[][] ocean, int r, int c, int incomingDepth) {
		if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length)
			return;
		if (ocean[r][c] != 0)
			return;

		if (matrix[r][c] >= incomingDepth)
			ocean[r][c] = 1;
		else
			ocean[r][c] = -1;

		for (int[] direction : directions) {
			dfs(matrix, ocean, r + direction[0], c + direction[0], matrix[r][c]);
		}
	}

	// #55 Jump game
	public boolean canJump(int[] nums) {
		int index = 0;

		while (index < nums.length && nums[index] > 0) {
			index = greedy(index, nums);
		}
		return index == nums.length - 1;
	}

	int greedy(int start, int[] nums) {

		int potential = nums[start];
		int best = start + 1;
		for (int i = start + 1; i < (start + potential) && i < nums.length; i++) {
			if (nums[best] - (best - start) < nums[i] - (i - start)) {
				best = i;
			}
		}
		return best;
	}

	public int[] plusOne(int[] digits) {
		Stack<Integer> stack = new Stack<>();

		boolean carry = true;// intial true for first push
		for (int i = digits.length - 1; i >= 0; i--) {
			int num = digits[i];
			if (carry)
				num++;
			carry = num >= 10;
			if (carry) {
				num = num % 10;
			}
			stack.push(num);
		}
		if (carry)
			stack.push(1);

		int[] arr = new int[stack.size()];
		int i = 0;
		while (!stack.isEmpty()) {
			arr[i++] = stack.pop();
		}
		return arr;
	}



}
