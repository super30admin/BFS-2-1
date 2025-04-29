/* Time Complexity : O(m*n) 
 *  m - rows of the matrix - grid
 *  n - cols of the matrix - grid */
/* Space Complexity : O(m*n)
*  m - rows of the matrix - grid
*  n - cols of the matrix - grid */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//BSF solution

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        int count_fresh = 0;

        //loop to find all the position of rotten oranges and the total count of fresh oranges
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});                    
                }else if(grid[i][j] == 1){
                    count_fresh++;
                }
            }
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};//right,left,down,up
        int time = 0;
        if(count_fresh == 0) return time;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    //boundary check
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        //fresh orange as the neighbor then add it's position to queue, 
                        //change the value to rotten, decrement the count of fresh oranges 
                        q.add(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                        count_fresh--;

                        if(count_fresh == 0) return time + 1;
                    }
                }
            }
            time++;
        }
        return -1;
    }
}