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

}
