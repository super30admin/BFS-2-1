//TC: O(m*n)
//SC: O(m*n)
//m - number of grid rows
//n - number of grid columns
//DFS
class Solution {
    int[][] dirs = new int[][] {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    int m;
    int n;    
    public int orangesRotting(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
                
        int t = 2;//offset time of 2
        //Iterate over the grid to find the rotten orange and perform dfs from each rotten orange
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                int curr = grid[i][j];
                if(curr == 2) {//rotten orange
                    dfs(grid, i, j, t);
                }
            }
        }
        //Iterate over the updated grid to check if there is any fresh orange present after all operations
        //Also find the final time taken by getting the max value from the grid
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                int curr = grid[i][j];
                if(curr == 1) return -1;
                t = Math.max(t, curr);
            }
        }

        return t - 2;               
    }

    private void dfs(int[][] grid, int r, int c, int time){
        //base
        //boundary condition
        if(r < 0 || r >= m || c < 0 || c >= n) return;
        //Return if the cell is not a fresh orange or already has a smaller (earlier) time value.
        if(grid[r][c] != 1 && grid[r][c] < time) return;
        //logic
        //set the grid val to curr time
        grid[r][c] = time;
        //checks all four adjacent directions (right, down, left, up)
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc, time + 1);
        }
    }
}