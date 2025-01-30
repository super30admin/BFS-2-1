
/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> current = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = dir[0] + current.getKey();
                    int newColumn = dir[1] + current.getValue();

                    if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n) {
                        if (grid[newRow][newColumn] == 1) {
                            queue.add(new Pair<>(newRow, newColumn));
                            fresh--;
                            grid[newRow][newColumn] = 2;
                        }
                    }
                }
            }
            time++;
        }
        if (fresh > 0) {
            return -1;
        }
        return time - 1;
    }
}
