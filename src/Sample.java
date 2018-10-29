
public class Sample {
	
	
	public static void main(String[] args) {
		int arr[] = new int[] {1,1,1,1,-1,-89,2,3,6};
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
        for (int i = 0; i < len; i++)
            if (arr[i] != i + 1)
                return i + 1;
        return len + 1;
    }
    

}
