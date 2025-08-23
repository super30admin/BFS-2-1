// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
// Did this code run on LeetCode: Yes, Accepted

// Approach:
// 1. Initialize queue with all initially rotten oranges and count fresh oranges.
// 2. Perform BFS level by level, where each level represents 1 minute.
// 3. For each rotten orange in the current level, rot all adjacent fresh oranges and enqueue them.
// 4. Decrement fresh count as oranges rot. Increment time after processing each level.
// 5. If fresh becomes 0, return time - 1 (since time is incremented after the last spread). Otherwise, return -1.


import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int[][] dirs;
    int m, n;

    public int orangesRotting(int[][] grid) {
        this.dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        this.m = grid.length;
        this.n = grid[0].length;
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;
        if(fresh == 0) return time;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();

                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                        fresh--;
                    }
                }
            }
            time++;
        }

        if(fresh == 0) return time - 1;
        return -1;
    }
}
