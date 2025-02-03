// In this problem, we are doing BFS. First traversing the grid and putting all rotten oranges indices in the queue and increasing the fresh 
// count if it is a fresh orange. Then if fresh count is 0 that means, no fresh orange present to make it rotten, so no time required so return 
// 0. Now start bfs till queue is empty, poll the rotten orange, and look at its 4 adjacent oranges, if they are fresh make it rotten, and 
// decrement the fresh count and also put the newly rottened orange to the queue. Maintain a size variable to increment time after each level 
// completes. At last if fresh oranges count is 0, return time - 1. Else return -1.

// Time Complexity : O(m*n) - traversing through grid
// Space Complexity : O(m*n) - queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int orangesRotting(int[][] grid) {
        // Base Case
        if (grid.length == 0 || grid[0].length == 0 || grid == null) {
            return -1;
        }
        // Calc grid length
        int m = grid.length;
        int n = grid[0].length;
        // Initialize the fresh count
        int fresh = 0;
        // Initialize time variable
        int time = 0;
        // Queue for storing the indices of rotten oranges
        Queue<int[]> q = new LinkedList<>();
        // Dirs array for calc indices of 4 adjacent neighbors
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // U D L R
        // Now traverse through the grid to put all the rotten in queue, and calc total
        // number of fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });

                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        // Check if fresh count is 0, return 0
        if (fresh == 0) {
            return 0; // No fresh orange, so no time to rot
        }
        // Else start bfs till queue is not empty
        while (!q.isEmpty()) {
            // Calc size of queue, this means all the rotten oranges in queue will transform
            // it's adjacent fresh oranges to rotten at the same time
            int size = q.size();
            // Start a loop till size
            for (int i = 0; i < size; i++) {
                // Poll the rotten orange
                int[] curr = q.poll();
                // Look at it's 4 adjacent neighbors
                for (int[] dir : dirs) {
                    // Calc the indices or position of that neighbor
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    // Check if it's a valid indice and if that orange is fresh
                    if ((nr >= 0 && nr < m) && (nc >= 0 && nc < n) && grid[nr][nc] == 1) {
                        // If it is, add it it's indices to the queue
                        q.add(new int[] { nr, nc });
                        // Decrement the fresh count
                        fresh--;
                        // Make it rotten
                        grid[nr][nc] = 2;
                    }
                }
            }
            // Now, after one level, increment time
            time++;
        }
        // Check if all oranges are not rotten
        if (fresh != 0) {
            // return -1
            return -1;
        }
        // Else, return time - 1
        return time - 1;
    }
}