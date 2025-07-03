/*
  Time complexity: O(N^2 * M^2)
  Space complexity: O(1)

*/

public class Solution {
    
    public int OrangesRotting(int[][] grid) {

        if(grid==null || grid[0].Length==0)
            return 0;

        int time = 0;
        int m = grid.Length;
        int n = grid[0].Length;
        Queue<(int row, int col)> queue = new();
        int fresh = 0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    fresh++;
                }
                if(grid[i][j]==2)
                {
                    queue.Enqueue((i,j));
                }
            }
        }

        if(fresh==0)
            return 0;
            
        while(queue.Count>0)
        {
            int size = queue.Count;
            time++;
            for(int i=0;i<size;i++)
            {
                var loc = queue.Dequeue();
                
                int[,] dir = new int[,]{{-1,0},{1,0},{0,1},{0,-1}};
                for(int j=0;j<4;j++)
                {
                    int item1 = loc.row+dir[j,0];
                    int item2 = loc.col+dir[j,1];
                    if(item1>=0 && item1<m && item2>=0 && item2<n && grid[item1][item2]==1)
                    {
                        grid[item1][item2] = 2;
                        queue.Enqueue((item1, item2));
                        fresh--;
                        Console.WriteLine("fresh:"+fresh);
                    }
                }
            }
        }

        return fresh==0?time-1:-1;

    }
}
