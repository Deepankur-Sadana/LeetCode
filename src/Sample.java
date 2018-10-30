import java.util.HashMap;
import java.util.Map;

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
		int i = 0, j = height.length -1;
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

}
