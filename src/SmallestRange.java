import java.util.*;

/**
 * 
 * #632
 *
 */
public class SmallestRange {

	class Item {
		int val, row, index;

		Item(int val, int row, int index) {
			this.val = val;
			this.row = row;
			this.index = index;
		}
	}

	public int[] smallestRange(List<List<Integer>> outer) {
		PriorityQueue<Item> pq = new PriorityQueue<>(new Comparator<Item>() {
			public int compare(Item a, Item b) {
				return a.val - b.val;
			}
		});
		int i = 0;
		int max = Integer.MIN_VALUE;
		for (List<Integer> list : outer) {
			pq.add(new Item(list.get(0), i++, 0));
			max = Math.max(max, list.get(0));
		}
		int[] res = new int[] { pq.peek().val, max };

		while (pq.peek().index != outer.get(pq.peek().row).size() - 1) {
			Item poll = pq.poll();
			List<Integer> polledList = outer.get(poll.row);
			int indexInPolledList = poll.index;
			indexInPolledList++;

			Item push = new Item(polledList.get(indexInPolledList), poll.row, indexInPolledList);
			pq.add(push);
			if (push.val > max)
				max = push.val;

			if (max - pq.peek().val < res[1] - res[0]) {
				res[1] = max;
				res[0] = pq.peek().val;
			}
		}
		return res;
	}

}
