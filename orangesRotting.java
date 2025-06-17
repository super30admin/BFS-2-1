// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// m = grid's row length n = grid's column length
/*Approach : we simple traverse through the grid and add all the cells marked as 2 into queue.
And also keep track of fresh oranges in freshCount. Now we traverse through queue for every cell marked as 2,
then we traverse in all four directions to see if there is any cell which is 1. if it is one then
it is marked as 2 and added to queue. whenever we mark a cell from 1 to 2 we simply decrement freshCount.
Once the cell is traversed in all directions we simply increment minutes variables indicating the time taken to
mark cell 1 with 2. In the end we check if freshCount is 0 then we return minutes value decremented by 1 has 
it takes one extra traversal through even after all the cells are marked 2.
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};       // directions array to traverse neighbouring rows and columns
        Queue<int []> q = new LinkedList<>();                   // initialize a queue
        int freshCount = 0;                                     // keeps track of fresh oranges
        int minutes = 0;                                        // keep track of time taken for cell with 1 to convert 2 in all directions
        if(grid == null || grid.length == 0 ) return minutes;   // validate if grid is empty
        for(int i=0; i<grid.length; i++){                       // traverse through grid's row length
            for(int j=0; j<grid[0].length; j++){                // traverse through grid's column length
                if(grid[i][j] == 2){                            // validate if cell is 2
                    q.add(new int[]{i,j});                      // add the cell to queue
                }
                if(grid[i][j] == 1){                            // validate if cell is 1
                    freshCount++;                               // increment freshcount to keep track of fresh oranges
                }
            }
        }
        if(freshCount == 0) return minutes;                     // validate freshcount if it 0 then there are no fresh oranges

        int m = grid.length;                                    // grid's row length
        int n = grid[0].length;                                 // grid's column length

        while(!q.isEmpty()){                                    // validate if queue is not empty     
            int size = q.size();                                // get size of current queue
            for(int i=0; i<size; i++){                          // traverse through queue's current size
                int [] cc = q.poll();                           // get first cell out of queue
                for(int[] dir : directions){                    // traverse in all directions
                    int nr = cc[0] + dir[0];                    // get neighbouring row index
                    int nc = cc[1] + dir[1];                    // get neighbouring column index
                    if(nr >= 0 && nc >= 0 && nr < m             // validate if neighbouring row's and column's index is in bounds and also cell is 1
                    && nc < n && grid[nr][nc] == 1){
                        q.add(new int[]{nr,nc});                // add neighbouring row and column index to queue
                        grid[nr][nc] = 2;                       // update cell to 2
                        freshCount--;                           // decrement freshCount
                        
                    }
                }
            }
            minutes++;                                          // increment minutes as the neighbouring cells of 1 is marked to 2           
        }
        if(freshCount != 0)return -1;                           // validate if any cell is 1, if yes return -1
        return minutes-1;                                       // return decremented value as the last cell is also traversed
    }
}