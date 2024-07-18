//Time Complexity: O(m2 . n2)
//Space Complexity: O(m . n)

class Solution {
    int freshCount;
    int m, n;
    int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    this.freshCount++;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    dfs(grid, 2, i, j);
            }

        if (freshCount != 0)
            return -1;
        int max = 2;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                max = Math.max(grid[i][j], max);
        return max - 2;
    }

    private void dfs(int[][] grid, int time, int i, int j) {
        // base
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1)
            return;
        if (grid[i][j] != 1 && grid[i][j] < time)
            return;

        // logic
        if (grid[i][j] == 1)
            freshCount--;
        grid[i][j] = time;
        for (int[] dir : dirs)
            dfs(grid, time + 1, i + dir[0], j + dir[1]);

    }
}