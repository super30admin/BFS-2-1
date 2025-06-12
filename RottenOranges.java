// Time complexity - O(n)
// Space Complexity - O(n)
// did u solve on leetcode- yes
// faced any issues- no
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, time = 0, n = grid.length, m = grid[0].length;
        if (n == 0) return -1;
        int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        Queue<int[]> q = new LinkedList<>();

        // Initialize queue and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0; // No fresh oranges initially

        // BFS level by level
        while (!q.isEmpty()) {
            int size = q.size();
            // I need this size because I have to calculate time at each level
            for (int i = 0; i < size; i++) {
                int[] rotten = q.poll();
                int x = rotten[0], y = rotten[1];

                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        grid[nx][ny] = 2;
                        fresh--;
                    }
                }
            }

            // If queue is not empty, it means there are more oranges to rot → increment time
            if (!q.isEmpty()) time++;
        }

        return fresh == 0 ? time : -1;
    }
}
