// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * First calculating how many fresh oranges we have and queueing the rotten oranges for bfs traversal.
 * At every step for a rotten orange, we go in all 4 directions and make the fresh orange rotten and queue it for next level of traversal.
 */
class Solution {
    int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // if fresh, add it to the counter
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    // queueing rotten to start bfs
                    q.add(new int[]{i, j});
                }
            }
        }

        int result = 0;
        if (freshCount == 0) return 0;

        while (!q.isEmpty()) {
            int size = q.size();
            result++;
            for (int i = 0; i < size; i++) {
                int[] entry = q.poll();
                for (int[] dir : dirs) {
                    int nr = entry[0] + dir[0];
                    int nc = entry[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        // change fresh orange to rotten and queue it for next round
                        grid[nr][nc] = 2;
                        freshCount--;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        // if fresh count is not 0, then there was some orange which was not rotted due to being unreachable
        // doing result - 1 since it will be one step ahead after rotting the last orange
        return freshCount == 0 ? result - 1 : -1;
    }
}