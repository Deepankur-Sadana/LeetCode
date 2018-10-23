import java.util.Arrays;

public class Utils {
	
	//do quick sort
	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));

	}

	public static void print(int[][] arr) {
		for (int[] x : arr) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}


}
