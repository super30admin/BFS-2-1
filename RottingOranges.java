// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes

//Description:
// - Enqueue all initially rotten oranges and count fresh oranges.
// - Perform multi-source BFS, rotting adjacent fresh oranges level by level.
// - Track elapsed time for each BFS level and return -1 if fresh oranges remain.

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][] {
                {-1, 0}, //up
                {1, 0}, //down
                {0, -1}, //left
                {0,1} //right
        };
        int rowSize = grid.length;
        int colSize = grid[0].length;

        Queue<int[]> cells = new LinkedList<>();
        int freshCount = 0;
        for(int i = 0; i < rowSize; i++) {
            for(int j = 0; j < colSize; j++) {
                if(grid[i][j] == 2) {
                    cells.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int time = 0;
        while(!cells.isEmpty() & freshCount > 0) {
            int size = cells.size();

            for(int i = 0; i < size; i++) {
                int[] cell = cells.poll();
                for(int[] direction : directions){
                    int newRow = cell[0] + direction[0];
                    int newCol = cell[1] + direction[1];

                    if(newRow >= 0 && newRow < rowSize && newCol >=0 && newCol < colSize && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshCount--;
                        cells.offer(new int[]{newRow, newCol});
                    }
                }
            }

            time++;
        }

        if(freshCount > 0) {
            return -1;
        }

        return time;
    }
}