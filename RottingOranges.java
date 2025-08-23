import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges{
    //Uing BFS, we start with all the rotting oranges available and add fresh oranges adjacent to these rotten ones into queue
    // we process the queue till all the possible oranges are traversed and return time elapsed
    // Time Complexity: O(m*n)
    // Space Complexity: O(m*n) 
    public int orangesRotting(int[][] grid) {
         int rows = grid.length;
         int cols = grid[0].length;
         int fresh = 0;
         int time = 0;
         int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
         Queue<int[]> q = new LinkedList<>();
         for(int i=0;i<rows;i++)
         {
            for(int j=0;j<cols;j++)
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
        int[] temp;
        int temprow, tempcol;
        if(fresh==0) return time;
        while(!q.isEmpty())
        {
            time++;
            for(int i=0;i<q.size();i++)
            {
            temp = q.poll();
            for(int[] dir : directions)
            {
                temprow = dir[0]+temp[0];
                tempcol = dir[1]+temp[1];

                if((temprow>-1 && tempcol>-1 && temprow<rows && tempcol<cols) && grid[temprow][tempcol]==1)
                {
                    q.add(new int[]{temprow,tempcol});
                    grid[temprow][tempcol] = 2;
                    fresh--;
                    
                }
            }
            }
        }
         
        if(fresh==0) return time-1;
        return -1;


    }
}