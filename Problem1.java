package BFS-2.1;

public class Problem1 {
    int m, n;
    int dirs;

    public int orangesRotting(int[][] grid) {

        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        if (freshOranges == 0)
            return 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int j = 0; j < qSize; j++) {
                int[] currentRotten = q.poll();
                for (int[] dir : dirs) {
                    int nr = currentRotten[0] + dir[0];
                    int nc = currentRotten[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        q.add(new int[] { nr, nc });
                        freshOranges--;
                        grid[nr][nc] = 2;

                        if (freshOranges == 0)
                            return time + 1;
                    }
                }
            }
            time++;
        }
        return -1;

    }
}
