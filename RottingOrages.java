//Solved Successfully on leetcode and faced no issues
//Time complexity: O(m*n)
//Space complexoty: O(m*n)


class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{0,1}, //right
        {-1,0}, //up
        {1,0},  //bottom
        {0,-1} //left
        };
        int fresh = 0;
        int time = 0;
        Queue<int[]>queue = new LinkedList<>();

        //counting fresh oranges & pushing rotten oranges into queue
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        //if there are no fresh oranges in the grid , return 0 , because there are nothing to make rot , so no time will be consumed.
        if(fresh == 0){
            return 0;
        }

        //we will start our bfs here
        while(!queue.isEmpty()){
            int queuesize = queue.size();
            for(int i = 0 ; i < queuesize ; i++){
                int[] curr = queue.remove();  //remove the pair(row n column indices of pushed rotten orange)
                int r = curr[0];
                int c = curr[1];
                //process the neighbours of current pair present in queue
                for(int[] dir : directions){
                    int newrow = r+dir[0];
                    int newcolumn = c+dir[1];
                    //do boundaries check
                    if(newrow >= 0 && newrow<m && newcolumn>=0 && newcolumn < n && grid[newrow][newcolumn] == 1){
                        queue.add(new int[]{newrow,newcolumn});
                        fresh--; 
                        grid[newrow][newcolumn] = 2;  //make it rot as soon as u put in queue
                    }
                }
            }

        time++; //increment time by 1 after u finish processing one level

        }
    
    if(fresh == 0){
        return time-1;
    }
    return -1;
}
}