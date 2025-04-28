//Time Complexity: 0(m*n)
//Space Complexity: 0(m*n)

/*
This code solves the Rotting Oranges problem using a Breadth-First Search (BFS) approach,
not DFS as initially mentioned. It identifies all rotten oranges at the start and uses a
queue to process their neighbors level by level. Each minute, newly rotten oranges are added
to the queue, and the time counter is incremented after processing each level.
If any fresh oranges remain after the process, the function returns -1, indicating not all oranges can rot.

Otherwise, it returns the total time taken minus one to adjust for the initial extra increment.
 */


import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int time=0;
        int countFreshOranges=0;

        Queue<int[]> queue=new LinkedList<int[]>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j]==1)
                    countFreshOranges++;

            }
        }

        if(countFreshOranges==0) return 0;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                int[] element=queue.poll();
                for(int[] dir:dirs)
                {
                    int r=element[0] + dir[0];
                    int c=element[1] + dir[1];
                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1)
                    {
                        grid[r][c]=2;
                        countFreshOranges--;
                        queue.add(new int[]{r,c});
                    }
                }
            }
            time++;
        }

        if(countFreshOranges>0) return -1;

        return time - 1;

    }
}
