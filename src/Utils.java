import java.util.*;

public class Utils {

	// do quick sort
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

	public static int[][] allDirections = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 },
			{ 1, 1 }, { 1, -1 } };

	public static int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static <V, K> Map<K, V> print(Map<K, V> map, Class<V> clazz) {
		if (clazz == Integer.class) {
			StringBuilder b = new StringBuilder();
			for (Map.Entry<K, V> entry : map.entrySet()) {
				b.append(entry.getKey());
				b.append("\t");
				b.append(entry.getValue());
				b.append("\n");
			}
			System.out.println(b.toString());

		}
//	    } else if// or if all the class type has same implementation use the 
		// || operator in the above if condition only.
//	            ...
		// and finally
		else {
			// either throw **IllegalArgument/Unsupported operation** exception
			// for the type 'V' Or handle in any other way you like to implement
		}
		return values;
	}

}
