import java.util.LinkedList;
import java.util.Queue;

public class rottingOranges 
{
    class Solution 
    {
        public int orangesRotting(int[][] grid) 
        {
            Queue<Integer> q = new LinkedList<>();
            int op = 0;
            int fresh = 0;

            for(int i = 0; i < grid.length; i++) 
            {
                for(int j = 0; j < grid[0].length; j++) 
                {
                    if(grid[i][j] == 2) {
                        op = -1;
                        int num = i * grid[0].length + j;
                        q.add(num);
                    } else if(grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }

            while(!q.isEmpty()) 
            {
                op++;
                Queue<Integer> qd = new LinkedList<>();
                while(!q.isEmpty()) {
                    int num = q.poll();
                    int i = num / grid[0].length;
                    int j = num % grid[0].length;

                    if(i - 1 >= 0) {
                        int n = (i - 1) * grid[0].length + j;
                        if(grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 2;
                            qd.add(n);
                            fresh--;
                        }
                    }
                    if(j - 1 >= 0) {
                        int n = i * grid[0].length + (j - 1);
                        if(grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 2;
                            qd.add(n);
                            fresh--;
                        }
                    }
                    if(i + 1 < grid.length) {
                        int n = (i + 1) * grid[0].length + j;
                        if(grid[i + 1][j] == 1 ) {
                            grid[i + 1][j] = 2;
                            qd.add(n);
                            fresh--;
                        }
                    }
                    if(j + 1 < grid[0].length) {
                        int n = i * grid[0].length + (j + 1);
                        if(grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 2;
                            qd.add(n);
                            fresh--;
                        }
                    }
                }
                q = new LinkedList<>(qd);
            }
            if (fresh > 0) 
            {
                return -1;
            }
            else 
            {
                if (op < 0)
                {
                    return 0;
                } 
                else 
                {
                    return op;
                }
            }
        }
    }
}
