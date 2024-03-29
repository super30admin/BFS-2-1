// Time Complexity : O(m*n) m == grid.length, n == grid[i].length
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes


class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    dfs(grid, 2, i,j,m,n);
                }
            }
        }
        int max = 2;
        for(int i = 0; i< m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1) return -1;
                max = Math.max(max, grid[i][j]);
            }
        }
        return max-2;
    }

    private void dfs(int[][] grid, int time, int r, int c, int m, int n){
        //base
        if(r < 0 || c < 0 || r == m || c == n || grid[r][c] == 0) return;
        if(grid[r][c] != 1 && grid[r][c] < time) return;
        //logic
        grid[r][c] = time;
        for(int[] dir : dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(grid, time+1, nr, nc,m,n);
        }
    }
}