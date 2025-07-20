// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

// We count fresh oranges and put rotten oranges in our bfs queue, start expanding from there. We will increment time by 1 after each pass. 

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int dirs[][] = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> bfs = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    bfs.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0; // no fresh oranges available

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int i = 0; i<size; i++) {
                int[] curr = bfs.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr>=0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        bfs.add(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }

            time++;
        }
        if (fresh!=0) return -1;
        return time - 1;
    }
}
