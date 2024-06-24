// Time Complexity : o( m x n )
// Space Complexity : O( m x n ) all fresh oranges, adding everything to queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length; // rows
        int n = grid[0].length; // cols
        Queue<int[]> q = new LinkedList<>(); // integer array to maintain coordinates
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // direction array
        int time = 0; // time, or levels
        int freshOranges = 0; 
        for (int i = 0; i < m; i++) { // getting fresh and rotten oranges and adding to the queue.
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0){ // no fresh oranges
            return 0;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr < m && nr >= 0 && nc < n && nc >= 0 && grid[nr][nc] == 1) {
                        q.add(new int[] { nr, nc });
                        grid[nr][nc] = 2;
                        freshOranges--;
                    }
                }
            }
            time++;
        }
        if (freshOranges != 0) {
            return -1;
        }
        return time - 1;
    }
}