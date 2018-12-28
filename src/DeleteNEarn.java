import java.util.Arrays;
import java.util.*;

public class DeleteNEarn {

	class ValFreq {
		int val, freq;

		ValFreq(int val, int freq) {
			this.val = val;
			this.freq = freq;
		}

	}

	public int deleteAndEarn(int[] nums) {
		Arrays.sort(nums);
		ArrayList<ValFreq> list = new ArrayList<>();

		for (int i : nums) {
			if (list.size() == 0)
				list.add(new ValFreq(i, 1));
			else {
				if (list.get(list.size() - 1).val == i) {
					++list.get(list.size() - 1).freq;
				} else {
					list.add(new ValFreq(i, 1));
				}
			}
		}

		int[] dp = new int[list.size()];
		dp[0] = list.get(0).val * list.get(0).freq;
		for (int i = 2; i < list.size(); i++) {

		}

		return dp[dp.length - 1];
	}

}
