import java.util.*;
import java.util.LinkedList;
// Time Complexity : O(m * n)
// Space Complexity : O(m * n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Intuition: use a queue to traverse the grid in a BFS manner, marking fresh oranges as rotten when adjacent to rotten oranges

public class RottingNaranja {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int freshcount = 0;
        int depth = 0;
        int max = 0;

        Queue<int[]> queue = new LinkedList();
        // add all rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    freshcount++;
                }
            }
        }

        // edge cases
        if (queue.isEmpty() && freshcount > 0)
            return -1;
        if (queue.isEmpty())
            return 0;

        // bfs all rotten oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshcount--;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            depth++;
            max = Math.max(max, depth);
        }

        if (freshcount > 0)
            return -1;

        return max - 1;
    }
}
