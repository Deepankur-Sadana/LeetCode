import java.util.Stack;

/**
 * # 155 MinStack
 *
 */
public class MinStack {

	Stack<Integer> stack;
	Stack<Integer> min;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<>();
		min = new Stack<>();
	}

	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(x);
			min.push(x);
		} else {
			min.push(min.peek() > x ? x : min.peek());
		}

	}

	public void pop() {
		stack.pop();
		min.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.peek();
	}

}
