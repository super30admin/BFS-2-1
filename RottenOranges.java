/*
* Approach 1: 
- Collect all rotten oranges and also count the number of fresh oranges
- Using a queue, keep track of every level, incremenet time per level, use dirs array to check the adjacent neighbours of the rotten orange, check bounds, make them rotten, decrease the number of fresh everytime an orange goes bad and check the count of fresh is equals to zero. 
- return total time taken if fresh == 0; else return -1
// TC: O(m * n) -> iterate over all the elements in the grid
// SC: O(m * n) -> size of the queue to store rotten oranges, worst case if all the oranges are rotten at first 

 */

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
         Queue<int[]> q = new LinkedList<>();
         int time = 0;
         // keep track of all the fresh oranges
         int fresh = 0;

         for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
                else if(grid[i][j] == 1)
                    fresh += 1;
            }
         }

        if(fresh == 0)
            return time;
         while(!q.isEmpty()){
            int size = q.size();
            time++;

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                //bounds check
                if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                    fresh--;
                    grid[r][c] = 2;
                    q.add(new int[]{r,c});
                    if(fresh == 0)
                        return time;
                }
                    
                } 
            }
         }
        return -1;
    }
}