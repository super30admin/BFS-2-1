class Solution {
    // Approach: BFS
    // TC: O(m * n)
    // SC: O(m * n) for queue
    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        int minNumOfMinutes = 0;
        int countOfFreshOranges = 0;
        // Add rotten orange indices to queue and maintain count of fresh oranges.
        Queue<int[]> indicesOfRottenOranges = new LinkedList<>();
        int numOfRows = grid.length;
        int numOfColumns = grid[0].length;
        for (int row = 0; row < numOfRows; row ++) {
            for (int column = 0; column < numOfColumns; column ++) {
                if (grid[row][column] == ROTTEN) {
                    indicesOfRottenOranges.offer(new int[] { row, column }); // add index
                } else if (grid[row][column] == FRESH) {
                    countOfFreshOranges ++; // increment count of fresh oranges
                }
            }
        }
        // No fresh oranges.
        if (countOfFreshOranges == 0) {
            return minNumOfMinutes;
        }
        // Iterate through all rotten oranges and rotten their neighbors.
        int countOfNewlyRottenOranges = 0;
        while (!indicesOfRottenOranges.isEmpty()) {
            int levelSize = indicesOfRottenOranges.size();
            while (levelSize -- != 0) {
                int[] rottenOrangeIndex = indicesOfRottenOranges.poll();
                int row = rottenOrangeIndex[0];
                int column = rottenOrangeIndex[1];
                // Check neighbors on all 4 directions.
                for (int[] direction: DIRECTIONS) {
                    int newRow = row + direction[0];
                    int newColumn = column + direction[1];
                    // Rotten the fresh orange.
                    if (newRow >= 0 && newColumn >= 0 && newRow < numOfRows && newColumn < numOfColumns
                        && grid[newRow][newColumn] == FRESH
                    ) {
                        grid[newRow][newColumn] = ROTTEN;
                        indicesOfRottenOranges.offer(new int[] { newRow, newColumn });
                        countOfNewlyRottenOranges ++;
                    }
                }
            }
            minNumOfMinutes ++; // increment after each level
            if (countOfFreshOranges == countOfNewlyRottenOranges) {
                // All oranges are rotten.
                return minNumOfMinutes;
            }
        }
        // Unable to rotten all oranges.
        return -1;
    }
}