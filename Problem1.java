public class Problem1 {
    //t.c->O(m*n)
    //s.c ->O(m*n)
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length ==0) {
            return 0;
        }
        int freshCount = 0;//counter for fresh oranges
        int time = 0;//time taken

        Queue<int[]> q = new LinkedList<>();//queue for bfs
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // directions for the neighbours
        int rowLength =  grid.length;
        int colLength = grid[0].length;
        //loop over every box and if its rotten at it to the queue to start bfs and if its fresh just inc the rotten count
        for(int i = 0;i<rowLength;i++){
            for(int j = 0;j<colLength;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        if(freshCount == 0){
            return 0;
        }
        while(!q.isEmpty()){
            //this will be needed to determine the time taken
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] curr =  q.poll();
                // for each popped from queue check its neighbours using dirs array and check if the value of neighbour is 1 means fresh then add to the queue and dec the fresh count and make it rotten.
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if(nr>=0 && nr<rowLength && nc >= 0 && nc < colLength && grid[nr][nc] ==1){
                        q.add(new int[]{nr,nc});
                        freshCount--;
                        grid[nr][nc] =2;
                    }
                }
            }
            //with increase in size increase the time
            time++;
        }
        if(freshCount != 0){
            return -1;
        }
        //why this because 1st time we added the rotten oranges
        return time-1;
    }

}
