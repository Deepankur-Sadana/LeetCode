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

	//103	Binary Tree Zigzag Level Order Traversal    
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

}
