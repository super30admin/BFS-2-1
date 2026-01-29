//TC - O(m * n)
//SC - O(n)

import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i =0;i<grid.length;i++) {
            for(int j = 0;j<grid[i].length;j++) {
                if(grid[i][j] == 1) {
                    freshOranges++;
                } else if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if(freshOranges == 0) return 0;
        if(q.isEmpty()) return -1;
        int time = 0;
        while(!q.isEmpty()) {
            time++;
            int size = q.size();
            for(int i = 0;i<size;i++) {
                int[] temp = q.poll();
                int r = temp[0];
                int c = temp[1];

                for(int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        freshOranges--;
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                    }
                }
            }

            
        }

        return freshOranges == 0 ? time-1 : -1;
    }
}