// Time Complexity: O(m*n) -- Iterate through the grid once to find all rotten oranges and then process the queue which in worst case can have all oranges i.e., m*n
// Space Complexity: O(m*n) -- In worst case, the queue can have all the oranges i.e., m*n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * The below solution uses BFS to solve the problem. We start by adding all the rotten oranges to the queue and counting the fresh oranges.
 * The base case when no fresh oranges are present is handled at the start. We then process the queue level by level, for each rotten orange, we check its 4-directional neighbors.
 * If a neighbor is a fresh orange , we rot it hence the freshcount decrements by 1 and to rot it just change its value to 2 and add the index of this neighbor to queue since it can rot other fresh oranges in next time frame.
 * If at any point the freshcount becomes 0, we need not process the grid further as we rotted all the fresh oranges, we can return the time+1 (The timeframe is incremented after rotting all the neighbors of current rotten oranges . Howeever if the freshcount becomes 0 even before rotting all the neighbors of current rotten oranges, we need to return time+1 since we are still in the same timeframe).
 * If after processing the queue, the freshcount is still not 0, it means we cannot rot all the fresh oranges hence return -1.
 */


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int time=0; 
        int freshcount=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                   q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1) freshcount++;
            }
        }
        if(freshcount == 0) return 0;
        while(!q.isEmpty())
        {
          int size=q.size();
          for(int i=0;i<size;i++)
          {
            int[] currIndex=q.poll();
            for(int[] dir:dirs)
            {
                int r=currIndex[0]+dir[0];
                int c=currIndex[1]+dir[1];
                if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1)
                {
                    freshcount--;
                    if(freshcount==0) return time+1;
                    grid[r][c]=2;
                    q.add(new int[]{r,c});  
                }
            }
          }
          time++;
        }
        return -1;

    }
    
}