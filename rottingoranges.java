class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid[0].length;
        int n=grid.length;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int time=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    dfs(grid,i,j,3,m,n,dirs);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
                time=Math.max(time,grid[i][j]);
            }
        }
        if(time==0||time==2) return 0;
        return time-2;
    }
    private void dfs(int[][] grid, int i,int j, int time, int m, int n,int [][]dirs){
        for(int[]dir:dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];

            if(nr>=0 && nr<n && nc>=0 && nc<m && (grid[nr][nc]==1 || grid[nr][nc]>time)){
                grid[nr][nc]=time;
                dfs(grid,nr,nc,time+1,m,n,dirs);
            }
        }
    }
}
