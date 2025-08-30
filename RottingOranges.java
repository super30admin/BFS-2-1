// Time Complexity : O(m*n) 
// Space Complexity : O(m*n) Adding all the elements index in queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In BFS, we add all the rotten oranges index to the queue initially. We iterate over the rotten oranges and find fresh oranges nearby. Once we find them we make them rotten and add them to the queue. Everytime a level gets processed, we increment the time. The next level includes all the newly rotten oranges. In the end we check if all the oranges are rotten. If not, we return -1.
// In DFS, we keep track of all the best times of newly rotten oranges in the grid using an offset. 3 - represents newly rotten orange at time 1 (1+2). We allow each orange to be visited multiple times to get the best time eventually. (this is like brute force dp solution).

class Solution {


    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int offset = 2;

    public int orangesRottingBFS(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        Queue<int[]> q =new LinkedList();  //O(m*n)
        int fresh = 0; int time =0;
        for(int i=0;i<m;i++)  //O(m*n) 
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
                if(grid[i][j]==1)
                    fresh++;
            }
        if(fresh == 0) return 0;

        while(!q.isEmpty()){  //O(m*n)
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cord = q.poll();
                for(int[] dir:dirs){  //O(1)
                    int nr = dir[0] + cord[0];
                    int nc = dir[1] + cord[1];

                    if(nr <0 || nc<0 || nr>=m || nc>=n) continue;
                    if(grid[nr][nc] == 1){
                        q.add(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                        fresh--;
                        if(fresh == 0) return time+1;
                    }
                }   
            }
            time++;
        }
        
        if(fresh !=0) return -1;
        return time-1;
    }

    public int orangesRottingDFS(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
  
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    dfs(grid, i,j,m,n,this.offset);
            }
        
        int max = 0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return -1;
                else{
                    max = Math.max(max,grid[i][j]);
                }
        }

        if(max == 0) return 0;
        return max - this.offset;
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, int time){
        if(i<0 || j<0 || i>=m || j>=n) return;
        if(grid[i][j] != 1 && grid[i][j] < time ) return;

        grid[i][j] = time;
        for(int[] dir:dirs){
            int nr = dir[0] +i;
            int nc = dir[1] + j;
            dfs(grid,nr,nc,m,n,time+1);
        }
    }
    
}
