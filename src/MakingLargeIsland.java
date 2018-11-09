import java.util.*;


// #827 making-a-large-island/
public class MakingLargeIsland {

	public static int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int largestIsland(int[][] grid) {
		if (grid.length == 0)
			return 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 1) {
					getNewColor();
					traverse(grid, r, c);
				}
			}
		}
		return Math.max(largetIsland(), getMax(grid) + 1);
	}

	int largetIsland() {
		int max = 0;
		for (int val : colorAreaMap.values()) {
			max = Math.max(max, val);
		}
		return max;
	}

	void traverse(int[][] grid, int r, int c) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
			return;
		if (grid[r][c] == 0 || grid[r][c] > 1)
			return;
		grid[r][c] = paintColor;
		colorAreaMap.put(paintColor, colorAreaMap.getOrDefault(paintColor, 0) + 1);

		for (int[] dir : directions)
			traverse(grid, r + dir[0], c + dir[1]);
	}

	HashMap<Integer, Integer> colorAreaMap = new HashMap<>();

	int paintColor = 1;

	int getNewColor() {
		return ++paintColor;
	}

	int getMax(int[][] grid) {

		int max = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 0) {
					HashSet<Integer> neighbourColors = new HashSet<>();
					for (int[] dir : directions) {
						int x = r + dir[0], y = c + dir[1];
						if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
							continue;
						neighbourColors.add(grid[x][y]);
						int area = 0;

						for (int color : neighbourColors) {
							area += colorAreaMap.get(color);
						}
						if (area > max)
							max = area;
					}
				}
			}
		}
		return max;
	}

}
