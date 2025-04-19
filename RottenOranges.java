import java.util.Queue;
import java.util.LinkedList;
// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
// Space Complexity: O(m * n) for the queue used in BFS, in the worst case where all oranges are rotten.
// LeetCode: https://leetcode.com/problems/rotting-oranges/

/**
 * Calculates the minimum time required to rot all fresh oranges in a grid.
 * Uses BFS to simulate the rotting process level by level from initially rotten oranges.
 * Returns -1 if not all fresh oranges can be rotted.
 */

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;

        Queue<int[]> queue = new LinkedList<>(); // row, column
        int freshOranges = 0; 
        
        int[][] dir = new int[][]{{ 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) { // rotten orange
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) { // fresh orange
                    freshOranges++;
                }
            }
        }
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isSpreading = false;
            for (int i = 0; i < size; i++) {
                int[] currentOrange = queue.poll();

                for (int[] d : dir) {
                    int newRow = d[0] + currentOrange[0];
                    int newCol = d[1] + currentOrange[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                            && grid[newRow][newCol] == 1) {
                        freshOranges--;
                        isSpreading = true;
                        grid[newRow][newCol] = 2;
                        queue.add(new int[] { newRow, newCol });
                    }
                }
            }
            if (isSpreading) {
                minutes++;
            }
        }

        return freshOranges == 0 ? minutes: -1;
    }
}
