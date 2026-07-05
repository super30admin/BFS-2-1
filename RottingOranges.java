//Time complexity : O(mn) where m is the number of rows, n is the number of columns
//Space complexity : O(mn) where m is the number of rows, n is the number of columns

class Solution {
    int result;
    int fresh;
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        result = 0;
        fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return result;
        }

        bfs(queue, grid, dirs, m, n);
        if (fresh != 0) {
            return -1;
        }
        return result;

    }

    void bfs(Queue<int[]> queue, int[][] grid, int[][] dirs, int m, int n) {
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coord = queue.poll();

                for (int[] dir : dirs) {
                    int row = coord[0] + dir[0];
                    int col = coord[1] + dir[1];
                    if (row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == 1) {
                        int neighbor = grid[row][col];
                        queue.add(new int[] { row, col });
                        grid[row][col] = 2;
                        fresh--;
                    }
                }
                if (fresh == 0) {
                    break;
                }
            }
            if (fresh == 0) {
                break;
            }
        }
    }
}