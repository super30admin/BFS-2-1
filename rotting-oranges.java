//TC: O(m*n)
//SC: O(m*n)

class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            //process the queue as per levels
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    //bounds check
                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        fresh--;
                        q.add(new int[] { r, c });
                        if (fresh == 0)
                            return time + 1;
                    }
                }
            }
            time++;
        }
        if (fresh != 0)
            return -1;
        return time - 1;
    }
}