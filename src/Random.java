import java.util.ArrayList;

public class Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

}
