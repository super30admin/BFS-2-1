public class Solution {
    public int OrangesRotting(int[][] grid) {
        int rows = grid.Length;
        int columns = grid[0].Length;
        Queue<(int row, int col)> q = new Queue<(int, int)>();
        int fresh=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(grid[i][j]==2)
                {
                    q.Enqueue((i,j));
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        int count=0;
        int result=0;
        while(q.Count>0)
        {
            int qSize = q.Count;
            result++;
            for(int k=0;k<qSize;k++)
            {
                var (r, c) = q.Dequeue();
                count++;
                if(c-1>=0&&grid[r][c-1]==1)
                {
                    fresh--;
                    grid[r][c-1]=2;
                    q.Enqueue((r,c-1));
                }
                if(c+1<columns && grid[r][c+1]==1)
                {
                    fresh--;
                    grid[r][c+1]=2;
                    q.Enqueue((r,c+1));
                }
                if(r-1>=0&&grid[r-1][c]==1)
                {
                    fresh--;
                    grid[r-1][c] =2;
                    q.Enqueue((r-1,c));
                }
                if(r+1<rows&&grid[r+1][c]==1)
                {
                    fresh--;
                    grid[r+1][c] =2;
                    q.Enqueue((r+1,c));
                }
            }
        }
        if(fresh==0) 
        {
            return result-1;
        }
        return -1;
    }
}