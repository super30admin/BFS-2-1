import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int [][] grid = {{2,1,1}, {1,1,0},{0,1,1}};

    public int bfs(int [][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i, j;
        int fresh = 0;
        Queue<int []> q = new LinkedList<int []>();
        int [][] dirn = {{0,-1},{1,0},{0,1},{-1,0}};

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                {
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    q.add(arr);                    
                }
                else if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    fresh++;
                }
            }
        }
        int timer = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int k;            
            for (k = 0; k < size; k++) {
                int [] coords = q.poll();
                int l;
                for (l = 0; l < dirn.length; l++)
                {
                    int new_x = coords[0] + dirn[l][0];
                    int new_y = coords[1] + dirn[l][1];
                    if (new_x >= 0 && new_x < m && new_y >= 0 && new_y < n && grid[new_x][new_y] == -1)
                    {
                        grid[new_x][new_y] = 2;
                        int [] s = new int[2];
                        s[0] = new_x;
                        s[1] = new_y;
                        q.add(s);
                        fresh--;
                    }
                }                
            }
            timer++;         
        }
        
        if (fresh == 0) {
            return timer-1;
        }
        else {
            return -1;
        }
    }
    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();
        System.out.println(ro.bfs(ro.grid));
    }
    
}
