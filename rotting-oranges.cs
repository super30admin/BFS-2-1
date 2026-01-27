
// Time Complexity: O(m × n)
// Space Complexity: O(m × n)

// Approach
// Initially add all  rotten oranges to a queue and count fresh oranges (multi-source BFS).
// Perform BFS level by level; each level represents one minute, rotting adjacent fresh oranges.
// If all fresh oranges rot, return total minutes taken; otherwise return -1.
public class Solution
{
    public int OrangesRotting(int[][] grid)
    {

        int[][] directions = new int[][]{new int[]{1,0},new int[]{-1,0},
        new int[]{0,1},new int[]{0,-1}};
        int time = 0;
        int freshOranges = 0;
        int rows = grid.Length;
        int cols = grid[0].Length;
        Queue<int[]> q = new();

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] == 2)
                {
                    q.Enqueue(new int[] { i, j });
                }
                if (grid[i][j] == 1)
                {
                    freshOranges++;
                }
            }
        }
        if (freshOranges == 0) return 0;

        while (q.Count > 0)
        {
            int size = q.Count();
            for (int i = 0; i < size; i++)
            {
                int[] cur = q.Dequeue();
                int startRow = cur[0];
                int startCol = cur[1];

                foreach (int[] dir in directions)
                {
                    int curRow = startRow + dir[0];
                    int curCol = startCol + dir[1];

                    if ((curRow >= 0 && curRow < rows) && (curCol >= 0 && curCol < cols)
                    && grid[curRow][curCol] == 1)
                    {
                        grid[curRow][curCol] = 2;
                        freshOranges--;
                        q.Enqueue(new int[] { curRow, curCol });
                    }
                }
            }
            time++;
        }
        return freshOranges == 0 ? time - 1 : -1;
    }
}



