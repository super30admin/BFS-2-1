// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
// Space Complexity: O(m * n) in the worst case due to the recursion stack (DFS).

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// - We perform a DFS from every initially rotten orange, passing the time as a value in the grid.
// - If we reach a fresh orange or an already rotted one with a worse (greater) time, we update it.
// - The grid is reused to store the time at which each orange becomes rotten (starting from 2).
// - After processing, we iterate through the grid to check if any fresh orange remains (value = 1).
// - If so, return -1. Otherwise, return max time seen minus 2 (since we started at 2 for initial rotten).

class Solution {
    int m ;
    int n;
    int[][] dir;
    public int orangesRotting(int[][] grid) {

        this.m = grid.length;
        this.n = grid[0].length;
        // 4 neighbouring directions
        this.dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        //Find rotten orange and call dfs on it
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2){
                    dfs(grid,i,j,2);
                }
            }
        }

        //Check max of all times
        int maxTime = 2; //offset used
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //if all the fresh oranges are not rott in the matrix, return -1.
                if(grid[i][j] == 1) return -1;
                else {
                    maxTime = Math.max(maxTime, grid[i][j]);
                }
            }
        }
        return maxTime - 2;

    }

    private void dfs(int[][] grid, int r, int c, int time) {

        // Check if not out of bounds and empty cell; return
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c] == 0) return;

        //Check if better time
        if(grid[r][c] != 1 && grid[r][c] < time) return;
        //Assign new time to the grid if earlier is not better
        grid[r][c] = time;

        //Check iin all 4 directions
        for(int[] d:dir){
            int r1 = r + d[0];
            int c1 = c + d[1];
            dfs(grid, r1, c1, time+1);
        }

    }
}