
// Time Complexity: O(m * n)
//   - Each cell is visited once
//   - BFS processes each orange at most once

// Space Complexity: O(m * n)
//   - Queue can hold all the oranges in the worst case

import java.util.*;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        if (m == 0) return 0;

        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] rotten = q.poll();
                for (int[] dir : dirs) {
                    int i = dir[0] + rotten[0];
                    int j = dir[1] + rotten[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        q.add(new int[]{i, j});
                        grid[i][j] = 2;
                        fresh--;
                    }
                }
            }
            count++;
        }

        return fresh != 0 ? -1 : count - 1;
    }

    public static void main(String[] args) {
        RottingOranges sol = new RottingOranges();

        int[][] grid1 = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int[][] grid2 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };

        System.out.println("Minutes to rot all oranges (Grid 1): " + sol.orangesRotting(grid1)); // Output: 4
        System.out.println("Minutes to rot all oranges (Grid 2): " + sol.orangesRotting(grid2)); // Output: -1
    }
}
