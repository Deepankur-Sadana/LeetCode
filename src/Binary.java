
public class Binary {

	public static void main(String[] args) {
//		System.out.println(isPalindrome("OPO"));
		Utils.print(count(40));
	}

	// 67 add-binary/
	public String addBinary(String sa, String sb) {
		char[] a = sa.toCharArray();
		char[] b = sb.toCharArray();

		int i = a.length - 1;
		int j = b.length - 1;

		StringBuilder res = new StringBuilder();
		boolean carry = false;
		while (i >= 0 || j >= 0) {

			int freq_1 = 0;

			if (i >= 0) {
				if (a[i--] == '1')
					freq_1++;
			}
			if (j >= 0) {
				if (b[j--] == '1')
					freq_1++;
			}
			if (carry)
				freq_1++;
			switch (freq_1) {
			case 0:
				res.append('0');
				carry = false;
				break;
			case 1:
				res.append('1');
				carry = false;
				break;
			case 2:
				res.append('0');
				carry = true;
				break;
			case 3:
				res.append('1');
				carry = true;
				break;
			}

		}
		if (carry)
			res.append('1');

		return res.reverse().toString();
	}

	// #58 length of last word
	public int lengthOfLastWord(String s) {
		s = s.trim();
		int index = s.length() - 1;
		char arr[] = s.toCharArray();
		while (index >= 0 && arr[index] != ' ') {
			--index;
		}

		if (index == 0)
			return 0;
		return s.length() - 1 - index;

	}

	// #345 reverse-vowels-of-a-string/
	public String reverseVowels(String s) {
		int i = 0, j = s.length() - 1;
		char[] arr = s.toCharArray();
		while (i < j) {
			while (!isVowel(arr[i]) && i < j) {
				i++;

			}
			while (!isVowel(arr[j]) && i < j) {
				j--;
			}

			if (i < j)
				swap(arr, i++, j--);
		}
		return String.valueOf(arr);

	}

	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	boolean isVowel(char c) {
		c = Character.toLowerCase(c);
		switch (c) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;

		default:
			return false;
		}

	}

	// #680 valid-palindrome
	public boolean validPalindrome(String s) {
		char arr[] = s.toCharArray();
		return validPalindrome(arr, 0, arr.length - 1, 0);

	}

	public boolean validPalindrome(char[] arr, int i, int j, int count) {
		if (count == 2)
			return false;
		while (i < j) {
			if (arr[i] != arr[j]) {
				return validPalindrome(arr, i + 1, j, count + 1) || validPalindrome(arr, i, j - 1, count + 1);
			}
			i++;
			j--;
		}
		return true;
	}

	// #125 valid-palindrome
	public static boolean isPalindrome(String s) {
		char[] arr = s.toCharArray();
		int i = 0, j = arr.length - 1;

		while (i < j) {
			while (i < j && !Character.isAlphabetic(arr[i])) {
				++i;
			}
			while (i < j && !Character.isAlphabetic(arr[j])) {
				--j;
			}
			if (i < j && Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j]))
				return false;
			++i;
			--j;

		}
		return true;
	}

	public int findSecondMinimumValue(TreeNode root) {

		return sM == null ? -1 : sM;
	}

	Integer M, sM;

	void search(TreeNode root) {
		if (root == null)
			return;
		if (M == null && sM == null) {
			M = root.val;
		} else if (M != null && sM == null) {

		} else if (root.val != sM && root.val != M) {

		}
		search(root.left);
		search(root.right);
	}

	boolean equal(int p, Integer r) {
		if (r == null)
			return false;
		return p == r;

	}

	boolean[][] mark;

	public int maxAreaOfIsland(int[][] grid) {
		if (grid.length == 0)
			return 0;
		mark = new boolean[grid.length][grid[0].length];

	}

	class NumArray {
		int[] sums;

		public NumArray(int[] nums) {
			if (nums.length == 0)
				return;
			sums = new int[nums.length];
			sums[0] = nums[0];

			for (int i = 1; i < nums.length; i++)
				sums[i] = sums[i - 1] + nums[i];

		}

		public int sumRange(int i, int j) {
			if (j == 0)
				return sums[j];
			int pre = 0;
			if (i > 0)
				pre = sums[i - 1];
			return sums[j] - pre;

		}
	}

	// #494 target-sum/
	public int findTargetSumWays(int[] nums, int S) {
		traverse(nums, 0, S, 0, true);
		traverse(nums, 0, S, 0, false);
		return count;
	}

	int count;

	void traverse(int[] nums, int running, int S, int index, boolean isPlus) {
		if (index == nums.length) {
			if (running == S)
				++count;
			return;
		}

		int nextRunner = isPlus ? running + nums[index] : running - nums[index];
		traverse(nums, nextRunner, S, index + 1, false);
		traverse(nums, nextRunner, S, index + 1, true);
	}
}
