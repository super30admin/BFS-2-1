// Time Complexity : O(m*n)
// Space Complexity : O(m*n)

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return time;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir: dirs) {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];

                    if (r>=0 && c>=0 && r<m && c<n && grid[r][c]==1) {
                        grid[r][c] = 2;
                        q.offer(new int[]{r,c});
                        fresh--;
                        if (fresh == 0) return time;
                    }
                }
            }
        }

        return -1;
    }
}