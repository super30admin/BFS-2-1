import java.util.*;

// BFS O(m * n) time, O(m * n) space
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = new int[][] {
            {0,1}, {1,0}, {-1,0}, {0,-1}
        };
        
        Queue<int[]> q = new LinkedList<>();

        int freshCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
                else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if (r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 1) {
                        q.offer(new int[] {r, c});
                        grid[r][c] = 2; // mark rotten
                        freshCount--;
                    }
                }
            }
            time++; // increment time after each level
        }
        if (freshCount == 0) return time-1;
        
        return -1;
    }
}
