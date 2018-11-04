
public class Binary {

	public static void main(String[] args) {

	}

	// 67 add-binary/
	public String addBinary(String sa, String sb) {
		char[] a = sa.toCharArray();
		char[] b = sb.toCharArray();

		int i = a.length - 1;
		int j = b.length - 1;

		StringBuilder res = new StringBuilder();
		boolean carry = false;
		while (i >= 0 || j >= 0) {

			int freq_1 = 0;

			if (i >= 0) {
				if (a[i--] == '1')
					freq_1++;
			}
			if (j >= 0) {
				if (b[j--] == '1')
					freq_1++;
			}
			if (carry)
				freq_1++;
			switch (freq_1) {
			case 0:
				res.append('0');
				carry = false;
				break;
			case 1:
				res.append('1');
				carry = false;
				break;
			case 2:
				res.append('0');
				carry = true;
				break;
			case 3:
				res.append('1');
				carry = true;
				break;
			}

		}
		if (carry)
			res.append('1');

		return res.reverse().toString();
	}

	// #58 length of last word
	public int lengthOfLastWord(String s) {
		s = s.trim();
		int index = s.length() - 1;
		char arr[] = s.toCharArray();
		while (index >= 0 && arr[index] != ' ') {
			--index;
		}

		if (index == 0)
			return 0;
		return s.length() - 1 - index;

	}

}
