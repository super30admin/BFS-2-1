class Solution {
    /*
        TC - O(m * n)
        SC - O(m * n)
        This solution uses multi-source BFS to simulate how the oranges rot minute by minute.
        First, all initially rotten oranges are added to a queue, and the number of fresh oranges is counted.
        If there are no fresh oranges, the answer is 0.
        The BFS processes the queue level by level, where each level represents one minute.
        For every rotten orange, its four neighboring cells are checked. If a neighboring orange is fresh, it becomes rotten, is added to the queue, and the fresh orange count is decreased.
        After processing one level of the queue, one minute has passed, so time is incremented.
        When the BFS finishes:
        If any fresh oranges remain, they could not be reached, so return -1.
        Otherwise, return time - 1, since the last increment happens after processing the final level.
     */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        q.add(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                        freshCount--;
                    }
                }
            } 
            time++;
        }

        if (freshCount != 0) return -1;

        return time - 1;
    }
}