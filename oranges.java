
TC: O(mn)^2

class Solution {
    int [][] dirs;
    public int orangesRotting(int[][] grid) {
        // dfs
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                dfs(grid, i, j, m, n,2);
                }
            }
        }
        
        int max =2;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
                max=Math.max(max,grid[i][j]);
            }
        }
        return max-2;
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, int time){

        if(i<0||j<0||i>=m||j>=n || grid[i][j]==0) return;
        if(grid[i][j] > 1 && grid[i][j]<time) return;
        else{
        grid[i][j]=time;
        for(int [] dir:dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            dfs(grid,nr,nc,m,n,time+1);
        }
        }
    }
}