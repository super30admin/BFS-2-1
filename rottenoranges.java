//Time Complexity: O(m × n) — Each cell is visited at most once during DFS.
//Space Complexity: O(m × n) — In the worst case, recursion stack may go as deep as the number of cells.

//Start DFS from every rotten orange (value 2), spreading rot with a time counter.
//Update each fresh orange with the time it gets rotten (if it's earlier than any previous infection).
//After DFS, if any fresh orange remains, return -1; otherwise, return the max time minus 2.

class Solution {
    int[][] dirs;
    int m,n;

    public int orangesRotting(int[][] grid) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = grid.length;
        this.n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    dfs(grid, i, j, 2);
                }
            }
        }

        int result = 2;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) return -1;
                else {
                    result = Math.max(result, grid[i][j]);
                }
            }
        }

        return result - 2;
    }

    private void dfs(int[][] grid, int i, int j, int time){
        // base case
        if(i < 0 || j < 0 || i == m || j == n) return;

        if(grid[i][j] != 1 && grid[i][j] < time) return;

        grid[i][j] = time;

        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            dfs(grid, r, c, time + 1);
        }
    }
}
