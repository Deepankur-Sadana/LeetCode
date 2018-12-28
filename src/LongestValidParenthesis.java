import java.util.Stack;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestValidParentheses(String s) {
		char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : arr) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				if (c == '(') {
					stack.push(c);
				} else {// trying to close ')'
					if (stack.size() == 1) {
						if (stack.peek() == '(') {
							stack.pop();
							stack.push('2');
						} else {
							stack.push(c);
						}
					} else {// pushing close with stack of size >= 2

					}

				}

			}
		}
	}

}
