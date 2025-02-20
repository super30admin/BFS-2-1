// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class RottingOrangesDFS {
    int [][] dirs;
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.dirs = new int [][]{{0,1}, {1,0},{-1,0},{0,-1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, m, n, 2);
                }
            }
        }

        int max =  0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                max = Math.max(max, grid[i][j]);
            }
        }
        if(max == 0) return 0;
        return max - 2;
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, int time) {
        if (i < 0 || j < 0 || i == m || j == n) return;
        if(grid[i][j] != 1 && grid[i][j] < time) return;

        grid[i][j] = time;
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, nr, nc, m , n, time + 1);
        }
    }
}
