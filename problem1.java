import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: o(m*n)
// Space Complexity: o(m*n)
//bfs
public class problem1 {

    int[][] dirs;
    int m, n;
    int time=0;
    public int orangesRotting(int[][] grid)
    {
        this.dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        this.m= grid.length;
        this.n= grid[0].length;
        int fresh=0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 2)
                {
                    q.offer(new int[]{i,j});
                }
                else if (grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }
        if (fresh==0){
            return time;
        }
        while (!q.isEmpty())
        {
            int size=q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) // checking all 4 directions
                {
                    int r= dir[0]+ curr[0];
                    int c= dir[1]+ curr[1];

                    if (r>=0 && c>=0 && r<m && c<n && grid[r][c] == 1) //check bounds
                    {
                        grid[r][c]=2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }

            }
            time++;
        }
        if (fresh!=0){
            return -1;
        }
        return time-1;
    }
}
