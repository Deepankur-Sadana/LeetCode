package models;

import java.util.*;


// #212
//https://leetcode.com/submissions/detail/189730256/
// Do using TRIE
public class WordSearch2 {

	public static int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	boolean[][] used;

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		used = new boolean[board.length][board[0].length];
		HashSet<String> set = new HashSet<>();

		for (String word : words) {
			if (set.contains(word))
				continue;
			boolean exists = false;
			boardLooper: for (int r = 0; r < board.length; r++) {
				for (int c = 0; c < board[0].length; c++) {
					exists = exists || exist(0, r, c, board, word);
					if (exists) {
						res.add(word);
						set.add(word);
						break boardLooper;
					}
				}
			}
		}

		return res;
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
			for (int[] dir : directions) {
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

}
