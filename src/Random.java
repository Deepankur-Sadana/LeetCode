import java.util.ArrayList;
import java.util.*;

public class Random {

	public static void main(String[] args) {

	}

	// #590 n-ary-tree-postorder-traversal/
	public List<Integer> postorder(Node root) {
		List<Integer> list = new ArrayList<>();
		traverse(root, list);
		return list;

	}

	// #507. Perfect Number
	public boolean checkPerfectNumber(int num) {
		int sum = 0;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				sum += i;
				sum += num / i;
			}
		}
		return sum + 1 == num && num > 1;
	}

	void traverse(Node root, List<Integer> list) {
		if (root == null)
			return;
		if (root.children != null) {
			for (Node n : root.children) {
				traverse(n, list);
			}
		}
		list.add(root.val);
	}

	// #804 unique-morse-code-words/
	public int uniqueMorseRepresentations(String[] words) {
		HashSet<String> set = new HashSet<>();
		String[] map = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
				".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
				"--.." };
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.delete(0, sb.length());
			for (char c : word.toCharArray()) {
				c = Character.toLowerCase(c);
				sb.append(map[c - 'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}

	// #128 longest-consecutive-sequence/
	public int longestConsecutive(int[] nums) {
		Arrays.sort(nums);
		int max = 0;
		int i = 0;
		while (i < nums.length) {
			int curr = i;
			int len = 1;
			while (i < nums.length - 1 && (nums[i + 1] == nums[i] || nums[i + 1] == nums[i] + 1)) {
				if (nums[i + 1] == nums[i] + 1)
					++len;
				++i;
			}
			max = Math.max(len, max);
			++i;
		}
		return max;
	}


	// #500 keyboard-row/
	public String[] findWords(String[] words) {
		String[] keyboard = { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };

		boolean[][] map = new boolean[keyboard.length][26];
		int i = 0;
		for (String row : keyboard) {
			char[] arr = row.toCharArray();
			for (char c : arr)
				map[i][c - 'A'] = true;
			++i;
		}

		ArrayList<Integer> rowsUsedList = new ArrayList<>();
		ArrayList<String> singleRowWords = new ArrayList<String>();
		for (String word : words) {
			rowsUsedList.clear();
			char[] arr = word.toCharArray();
			stringLooper: for (char c : arr) {
				c = Character.toUpperCase(c);
				int j = 0;
				for (boolean[] keysInARow : map) {
					if (keysInARow[c - 'A']) {
						if (!rowsUsedList.contains(j))
							rowsUsedList.add(j);
						if (rowsUsedList.size() > 1)
							break stringLooper;
					}
					j++;
				}
			}

			if (rowsUsedList.size() < 2)
				singleRowWords.add(word);
		}
		return singleRowWords.toArray(new String[singleRowWords.size()]);

	}

	// #461 Hamming Distance
	public int hammingDistance(int x, int y) {
		int sum = 0;
		int xor = x ^ y;
		while (xor != 0) {
			sum += (xor & 1) == 1 ? 1 : 0;
			xor = xor >> 1;
		}
		return sum;
	}

	// #477 total-hamming-distance
	public int totalHammingDistance(int[] nums) {
		int i = 32;
		int sum = 0;

		while (i-- != 0) {
			int ones = 0;
			for (int j = 0; i < nums.length; j++) {
				ones += (nums[j] & 1) == 1 ? 1 : 0;
				nums[j] = nums[j] >> 1;
			}
			sum += ones * (nums.length - ones);
		}
		return sum;
	}

	// #917 reverse-only-letters
	public String reverseOnlyLetters(String S) {
		char arr[] = S.toCharArray();
		int i = 0, j = arr.length - 1;
		while (i < j) {
			while (!isAlphabet(arr[i]) && i < j) {
				++i;
			}

			while (!isAlphabet(arr[j]) && i < j) {
				--j;
			}
			if (i < j) {
				char temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
			++i;
			--j;
		}
		return String.valueOf(arr);
	}

	boolean isAlphabet(char c) {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	boolean[][] used;

	// #79 Word Search
	public boolean exist(char[][] board, String word) {
		used = new boolean[board.length][board[0].length];

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (exist(0, r, c, board, word)) {
					return true;
				}
			}
		}
		return false;
	}

	boolean exist(int index, int r, int c, char[][] board, String word) {

		if (index == word.length())
			return true;
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
			return false;
		if (used[r][c])
			return false;

		if (board[r][c] == word.charAt(index)) {
			used[r][c] = true;
			boolean exist = false;
			for (int[] dir : Utils.directions) {
				exist = exist || exist(index + 1, r + dir[0], c + dir[1], board, word);
				if (exist)
					break;
			}
			used[r][c] = false;
			return exist;
		} else {
			return false;
		}
	}


	// #938 range-sum-of-bst/
	public int rangeSumBST(TreeNode root, int L, int R) {
		traverse(root, L, R);
		return sum;
	}

	int sum = 0;

	void traverse(TreeNode root, int L, int R) {
		if (root == null)
			return;
		traverse(root.left, L, R);
		int val = root.val;
		if (val >= L && val <= R)
			sum += val;
		traverse(root.right, L, R);

	}

	int minLen = Integer.MAX_VALUE;
	// #209  minimum-size-subarray-sum
	public int minSubArrayLen(int k, int[] A) {

		int len = A.length;
		if (len == 0 || k <= 0)
			return 0;
		int sum = 0;
		int l = 0, r = 0;

		while (r < len) {
			sum += A[r++];
			while (sum >= k) {
				checkLength(l, r);
				sum -= A[l++];
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	void checkLength(int l, int r) {
		if (minLen > r - l) {
			minLen = r - l;
		}
	}

	// Given a string S and a string T,
	// find the minimum window in S which wil
	// l contain all the characters in T in complexity O(n).
	// #76 minimum-window-substring/

	class CharFreq {
		char c;
		int freq;

		CharFreq(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}
	}

	public String minWindow(String s, String t) {
		int[] cntS = new int[256];
		int[] cntT = new int[256];
		int res[] = new int[] { 0, Integer.MAX_VALUE };
		for (char c : t.toCharArray()) {
			System.out.println(" c :" + c);
			cntT[c]++;
		}
		ArrayList<CharFreq> list = new ArrayList<CharFreq>();
		for (int i = 0; i < cntT.length; i++) {
			if (cntT[i] > 0) {
				list.add(new CharFreq((char) i, cntT[i]));
				System.out.println(" c :" + (char) i + " f " + cntT[i]);
			}
		}

		System.out.println(" size :" + list.size());
		int l = 0, r = 0;
		char[] arr = s.toCharArray();
		while (r < arr.length) {
			char c = arr[r++];
			cntS[c]++;

			while (containsAll(cntS, list)) {
				System.out.println("l " + l + " r " + r);
				if (res[1] - res[0] > r - l) {
					res[0] = l;
					res[1] = r;
				}
				char cI = arr[l++];
				cntS[cI]--;
			}
		}

		if (res[1] == Integer.MAX_VALUE && res[0] == 0)
			return "";
		return s.substring(res[0], res[1]);
	}

	boolean containsAll(int[] cntS, ArrayList<CharFreq> list) {
		for (CharFreq cf : list) {
			if (cntS[cf.c] < cf.freq)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println("ADOBECODEBANC".substring(8, 13));
	}

}
