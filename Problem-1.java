// Time Complexity : O(M × N)
// Space Complexity : O(M × N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach: We use multi-source BFS by first adding all initially rotten oranges
// into the queue and counting fresh oranges. Each BFS level represents 1 minute,
// and we rot all adjacent fresh oranges while decreasing the fresh count.
// At the end, if no fresh oranges remain, we return the total minutes taken;
// otherwise, we return -1.


import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;

        // Step 1: Add all rotten oranges to queue and count fresh ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // Step 2: Multi-source BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();

                for (int[] dir : dirs) {
                    int nr = top[0] + dir[0];
                    int nc = top[1] + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            grid[nr][nc] = 2; // mark rotten
                            freshCount--;
                            queue.offer(new int[]{nr, nc});
                            rottedThisRound = true;
                        }
                    }
                }
            }

            if (rottedThisRound) {
                minutes++;
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
