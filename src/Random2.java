import java.util.*;

public class Random2 {

	// #49. Group Anagrams
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, LinkedList<String>> map = new HashMap<>();
		for (String str : strs) {
			String h = getHash(str);
			if (map.get(h) == null)
				map.put(h, new LinkedList<String>());
			map.get(h).add(str);
		}
		return new ArrayList<>(map.values());
	}

	String getHash(String s) {
		char[] chars = s.toCharArray();
		int[] f = new int[26];
		for (char c : chars) {
			f[c - 'a']++;
		}
		String r = Arrays.toString(f);
		System.out.println(" input " + s + " hash " + r);
		return r;
	}

}
