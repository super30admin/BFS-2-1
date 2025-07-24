// TC and SC O(m * n)
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}}; // UDLR
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // This condition is needed. Otherwise instead of returning 0, we return -1 at the end when no fresh oranges are present.
        if (fresh == 0) {
            return 0;
        }

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; ++i) {
                int[] cur = q.poll();
                
                for (int[] dir: dirs) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[] {nr, nc});
                        fresh--;
                    }
                }

            }
            time++;
        }
        // Last iteration of the while loop, we change to rotten oranges and then add to the queue.
        // But we have already rotten all oranges. But the queue is not empty, while loop it executes one more time.
        // this increases the time variable. Therefor ereturn time - 1
        return fresh == 0 ? time - 1 : -1;

    }
}