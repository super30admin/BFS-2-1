// Time Complexity : O(m * n)
// Space Complexity : O(m * n) (queue + grid)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES

class RottingOranges_LC994 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int columns = grid[0].length;
        int minutes = 0, freshCount = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) freshCount++;
            }
        }

        if (freshCount == 0) return 0;
        while (!queue.isEmpty()) {
            boolean infected = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : directions) {
                    int nr = pos[0] + dir[0];
                    int nc = pos[1] + dir[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < columns && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        freshCount--;
                        infected = true;
                    }
                }
            }
            
            if (infected) minutes++;
        }


        return (freshCount == 0) ? minutes : -1;
    }
}