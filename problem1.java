// Time Complexity : O(m * n) where m is the number of rows and n is the number of columns in the grid
// Space Complexity : O(m * n) for the queue used to store the rotten oranges 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Used level order BFS to spread the rot from rotten oranges to fresh ones. Each level of BFS represents one minute.
// If there are no fresh oranges at the start, return 0. If there are still fresh oranges left after the BFS completes, return -1.
// For each rotten orange, check its four adjacent cells (up, down, left, right) and if any of them contain a fresh orange,
// rot it and add it to the queue for the next minute. Keep track of the number of fresh oranges and return the time taken to rot all of them.

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) queue.offer(new int[]{r, c});
                else if (grid[r][c] == 1) freshCount++;
            }
        }
        if (freshCount == 0) return 0;
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];
                for (int[] dir : directions) {
                    int newR = r + dir[0], newC = c + dir[1];
                    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        queue.offer(new int[]{newR, newC});
                        freshCount--;
                        if(freshCount==0) return minutes+1;
                        rottedThisMinute = true;
                    }
                }
            }
            if (rottedThisMinute) minutes++;
        }
        return -1;
    }
}
