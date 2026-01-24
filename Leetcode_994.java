//way1

//BFS
//Place first rotten oranges in queue
//Pop queue elements out and add it's boundary rotten oranges
//Consider as a level order and for every level increment time by 1
//AFter the queue becomes empty, check for fresh oranges. If fresh oranges still present return -1
//Else return time
//TC: O(m*n)
//SC: O(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int freshCount=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    freshCount+=1;
                }
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }

        }

        if(freshCount==0) return 0;

        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int time=0;

        while(!(queue.isEmpty())){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();

                for(int[] d:dir){
                    int r=curr[0]+d[0];
                    int c=curr[1]+d[1];

                    if((r>=0 && r<m) && (c>=0 && c<n)){
                        if(grid[r][c]==1){
                            queue.add(new int[]{r,c});
                            grid[r][c]=2;
                            freshCount-=1;

                            if(freshCount==0) return time+1;
                        }
                    }
                }
                
            }
            time+=1;
        }

        if(freshCount==0) return time-1;
        return -1;

        
    }
}


//way2
//DFS
//For every 2 - make DFS call
//Update every 1 with possible nearest dis
//Recursively it will lead to the correct solution
//TC: O(m*n); SC:(m*n)
class Solution {
    int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    helper(grid,i,j,2);
                }
            }
        }

        int time=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.println(grid[i][j]);
                if(grid[i][j]==1){
                    return -1;
                }else{
                    if(grid[i][j]>1){
                        grid[i][j]=grid[i][j]-2;
                        time=Math.max(time,grid[i][j]);
                    }
                }
                
            }
        }

        return time;
        
    }

    private void helper(int[][] grid, int r, int c, int time){
        //
        if(r<0 || c<0 || r==grid.length || c==grid[0].length ){
            return;
        }

        if(grid[r][c]<time && grid[r][c]!=1){
            return;
        }

        grid[r][c]=time;

        //
        for(int[] d:dir){
            int cr=r+d[0];
            int cc=c+d[1];

            helper(grid,cr,cc,time+1);
        }
    }
}
