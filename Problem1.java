// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Problem1 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        //edge case
        if (m == 0)
            return 0;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });
                if (grid[i][j] == 1)
                    fresh++;
            }
        }
        if (fresh == 0)
            return 0;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] rotten = q.poll();
                for (int[] dir : dirs) {
                    int i = dir[0] + rotten[0];
                    int j = dir[1] + rotten[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        q.add(new int[] { i, j });
                        grid[i][j] = 2;
                        fresh--;
                    }
                }
            }
            count++;
        }
        if (fresh != 0)
            return -1;
        return count > 0 ? count - 1 : 0;
    }
}
