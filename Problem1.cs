// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I use two variables freshCount (to keep track of total number of fresh oranges present in the grid at any point of time) and minutes(total 
minutes takes so far). I use a queue of int[] which holds the row and column position of rotten oranges. I traverse through the entire grid once
and for every rotten orange present, I add it's row and column position to the queue and for every fresh orange I increment freshCount 
by 1. If no fresh oranges are present at first I return 0 as the result. Then I perform BFS, I traverse though the elements of the queue
q.Count number of times(this represents activity that happens during each minute). For each rotten orange(element dequeued), I check 
it's 4 directional neighbours. If any of the neighbours is a fresh orange, I convert them into a rotten orange and decrement freshCount by 1
These newly rotten oranges row and column positions are added to the queue. I perform BFS until the queue is empty and freshCount >0. 
If freshCount is still 0, I return -1 or I return the total minutes passed so far.
*/

public class Solution {
    public int OrangesRotting(int[][] grid) {
        int freshCount = 0, minutes = 0;
        int rows = grid.Length, columns = grid[0].Length;
        Queue<int[]> q = new();

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(grid[i][j] == 1)
                {
                    freshCount+=1;
                }

                else if(grid[i][j] == 2)
                {
                    q.Enqueue(new int[] {i,j});
                }
            }
        }

        if(freshCount == 0)
        {
            return minutes;
        }

        int[][] dirs = new int[][]
        {
            new int[] {0,1},
            new int[] {1,0},
            new int[] {0,-1},
            new int[] {-1,0}
        };

        while(q.Count != 0  && freshCount >0)
        {
            int size = q.Count;

            for(int i = 0; i < size; i++)
            {
                int[] pos = q.Dequeue();

                foreach(int[] dir in dirs)
                {
                    int nr = pos[0] + dir[0];
                    int nc = pos[1] + dir[1];

                    if(nr>=0 && nr<rows && nc>=0 && nc<columns)
                    {
                        if(grid[nr][nc] == 1)
                        {
                            grid[nr][nc] = 2;
                            freshCount -= 1;
                            q.Enqueue(new int[] {nr,nc});
                        }
                    }
                }
            }

            minutes += 1;
        }

        return freshCount == 0? minutes : -1;

    }
}