// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/*
  Use BFS to traverse the 2D array and rot the surrounding oranges.
  create a queue of rotten oranges and count fresh oranges
  use the direction array and do BFS and rot the surrounding oranges.
  At each level increment time
  Add edge case to return time as 0 when no rotten oranges initially
  when the fresh==0 then return time-1
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        // Directions: up, down, left, right
        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> que = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;

        // Step 1: Count fresh oranges and add initial rotten oranges to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++; // fresh orange
                }
                if (grid[i][j] == 2) {
                    que.add(new int[] { i, j }); // rotten orange
                }
            }
        }

        // No fresh oranges, return 0
        if (fresh == 0)
            return 0;

        // Step 2: BFS to rot adjacent fresh oranges
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] curr = que.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    // If neighbor is within bounds and is fresh
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // rot it
                        fresh--; // one less fresh orange
                        que.add(new int[] { nr, nc }); // add new rotten to queue
                    }
                }
            }
            time++; // time after each level
        }

        // Step 3: Return result
        return fresh == 0 ? time - 1 : -1;
    }
}
