
//Time complexity:O(n*m)
//space complexity:O(n*m);

//I used BFS traversal, where I started with all the rotten oranges in the queue and
// then processed each level of the BFS. At each level, I checked the four possible directions
// for fresh oranges and turned them rotten if they were adjacent to a rotten orange.
//Finally, I returned the time taken for all oranges to rot or -1 if there were still fresh oranges left.
//Time will be incremented after every level of BFS.


class Solution {
    //BFS
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int dirs[][]=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        int n=grid.length,m=grid[0].length,fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2)
                    q.add(new int[]{i,j});
            }
        }
        int time=0;
        if(fresh==0)
            return time;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.remove();
                for(int dir[]:dirs){
                    int r=curr[0]+dir[0];
                    int c=curr[1]+dir[1];
                    if(r>=0&&c>=0&&r<n&&c<m&&grid[r][c]==1){
                        grid[r][c]=2;   //make it rotten
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;   //increment time after every level
        }
        if(fresh==0)
            return time-1;
        else
            return -1;
    }
}