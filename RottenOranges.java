import java.util.LinkedList;
import java.util.Queue;

//Approach-1 : BFS
public class RottenOranges {
    int[][] dirs;

    public int orangesRotting(int[][] grid) {
        this.dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;
        if (fresh == 0)
            return 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];

                    if (r >= 0 && c >= 0 && r < m && c < n) {
                        if (grid[r][c] == 1) {
                            grid[r][c] = 2;
                            fresh--;
                            q.add(new int[]{r, c});
                        }
                    }
                }
            }
            time++;
        }

        if (fresh == 0)
            return time - 1;
        return -1;
    }
}

// TC: O(m*n), SC: O(m*n))

//Approach- 2 : DFS
class Solution {
    int[][] dirs;
    int m, n;

    public int orangesRotting(int[][] grid) {
        this.dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        this.m = grid.length;
        this.n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, 2);
                }
            }
        }

        int res = 2;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
                else {
                    res = Math.max(res, grid[i][j]);
                }
            }
        }

        return res - 2;

    }

    private void dfs(int[][] grid, int i, int j, int time) {
        //base case
        grid[i][j] = time;

        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;

            if (r >= 0 && c >= 0 && r < m && c < n && (grid[r][c] == 1 || grid[r][c] > time)) {
                dfs(grid, r, c, time + 1);
            }
        }
    }
}

// TC: O(m*n), SC: O(m*n))
