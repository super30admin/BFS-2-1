class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0)
        return -1;
        int m = grid.length;
        int n= grid[0].length;
        int fresh=0;
        int time=0;
        Queue<int[]>q = new LinkedList<>();
        //directions array to move right, left, down, up
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                    if(grid[i][j]==2)
                    {
                        q.add(new int[]{i,j});

                    }
                    if(grid[i][j]==1)
                    {
                        fresh++;
                    }
            }
        }
        if(fresh==0)
        return 0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int cur[]=q.poll();
                for(int [] dir: dirs)
                {
                    int nr = cur[0]+dir[0];
                    int nc = cur[1]+dir[1];

                    //bounds check
                    if(nr >=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1)
                    {
                            //add newly found fresh oranges beside rotten as they gets rotten next
                            q.add(new int[]{nr,nc});
                            //mark rotten
                            grid[nr][nc]=2;
                            fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh!=0)
        return -1;
        return time-1;
    }
}

//tc: O(m X n)
//sc: O(m X n)