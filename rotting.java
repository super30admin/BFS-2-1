class Solution {
    int[][] dirs;
    int m,n;
    public int orangesRotting(int[][] grid) {
        this.dirs=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        this.m=grid.length;
        this.n=grid[0].length;
        int fresh=0;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int time=0;
        if(fresh==0)return time;
        while(!q.isEmpty()){
            int size=q.size();
            time++;
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
            for(int[] dir:dirs){
                int nr=curr[0]+dir[0];
                int nc=curr[1]+dir[1];
                if(nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    q.add(new int[]{nr,nc});
                    fresh--;
                    if(fresh==0)return time;
                }
            }
        }
        }
        return -1;
    }
}