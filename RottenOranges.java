// Time Complexity : O(m*n) m*n matrix size, since visiting max m*n cells.
// Space Complexity : O(m*n) using queu extra space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    private boolean isValid(int row, int col, int m, int n )
    {
        if(row < 0 || row > m-1 || col > n-1 || col < 0)
            return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        Queue<List<Integer>> que = new LinkedList<>();

        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j] == 2)
                    que.offer(new ArrayList<>(Arrays.asList(i, j)));

        int noOfMinutes = 0;
        while(!que.isEmpty())
        {
            int len = que.size();
            while(len>0)
            {
                List<Integer> rotten = que.poll();
                int[] x = new int[]{-1, 0, 1, 0};
                int[] y = new int[]{0, 1, 0,-1};
                for(int i=0, j=0; i<4 && j<4; i++, j++)
                {
                    int ni = rotten.get(0) + x[i];
                    int nj =  rotten.get(1) + y[i];
                    if(isValid(ni, nj, grid.length, grid[0].length))
                    {
                       List<Integer> temp = new ArrayList<Integer>(Arrays.asList(ni, nj));
                        if(grid[ni][nj] == 1)
                        {
                            grid[ni][nj] = 2;
                            que.offer(temp);
                        }
                    }
                }
                
                len--;
            }
            if(que.size()>0)
                    noOfMinutes++;
        }
         for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j] == 1)
                    return -1;
            
               
            
        return noOfMinutes;
        
    }
}