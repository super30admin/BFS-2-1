// time complexity - O(n*m) 
// space complexity - O(n*m) 
public class Solution
{
    public int OrangesRotting(int[][] grid)
    {
        int[][] dir = new int[][] { [1, 0], [-1, 0], [0, 1], [0, -1] };
        int level = 0;
        Queue<int[]> bfs = new Queue<int[]>();
        int fresh = 0;
        for (int i = 0; i < grid.Length; i++)
        {
            for (int j = 0; j < grid[0].Length; j++)
            {
                if (grid[i][j] == 1)
                {
                    fresh++;
                }
                else if (grid[i][j] == 2)
                {
                    bfs.Enqueue([i, j]);
                }
            }
        }
        if (fresh == 0)
        {
            return 0;
        }
        while (bfs.Count() > 0)
        {
            int size = bfs.Count();
            while (size > 0)
            {
                int[] curr = bfs.Dequeue();
                foreach (var d in dir)
                {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr >= 0 && nr < grid.Length && nc >= 0 && nc < grid[0].Length && grid[nr][nc] == 1)
                    {
                        bfs.Enqueue([nr, nc]);
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
                size--;
            }
            level++;
        }
        if (fresh == 0)
        {
            return level - 1;
        }
        else
        {
            return -1;
        }
    }
}