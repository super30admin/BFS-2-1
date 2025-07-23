// We use BFS to count the number of minutes it would take to convert all fresh oranges to rotten oranges
// TC: O(n) - single pass multiple times but overall O(n)
// SC: O(n) - in queue, we would store all nodes/grid indexes

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Count fresh oranges and enqueue all initially rotten ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;  // No fresh oranges to rot

        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int minutes = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            minutes++;
            for (int i = 0; i < levelSize; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int nr = cell[0] + dir[0];
                    int nc = cell[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
