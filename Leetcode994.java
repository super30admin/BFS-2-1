// Solution -  DFS 
// TC - O(mn)
// SC - O(mn) maximum size of queue. 
class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int time = 0;
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    freshCount++;
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        if (freshCount == 0)
            return 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] val = q.poll();
                for (int[] dir : dirs) {
                    int r = val[0] + dir[0];
                    int c = val[1] + dir[1];
                    if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[] { r, c });
                        freshCount--;
                    }
                }
            }

            time += 1;
        }
        if (freshCount > 0) {
            return -1;
        }
        return time - 1;

    }
}