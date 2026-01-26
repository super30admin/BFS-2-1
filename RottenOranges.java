import java.util.LinkedList;
import java.util.Queue;

/*
Time Complexity : O(MXN), M is the rows and N is the cols in the matrix
Space Complexity : O(MXN), the leaf nodes will in the queue.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach :

BFS:
We can identify all rotten oranges location and add to the queue. We can do bfs traversal on each rotten orange and add
them to the queue. To make sure, we avoid picking same fresh orange again, we change the fresh orange matrix[i][j] value
to rotten orange. Once oranges for one level is processed, we increase the number of minutes to rot. At the end, if all
oranges are not rotten, return -1, else return minutes to rot.
*/
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int freshOrangeCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Count the fresh oranges
                if (grid[i][j] == 1) {
                    freshOrangeCount++;
                }

                // add all rotten oranges to queue
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (freshOrangeCount == 0) return 0;

        // To find children in all 4 directions
        int[][] dirs = new int[][]{{-1,0},{0,-1}, {1,0},{0,1}};
        int minimumSeconds = 0;
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();
            minimumSeconds++;
            // Process the current level
            for (int index = 0; index < currentLevel; index++){
                int[] currentOrange = queue.remove();
                int i = currentOrange[0];
                int j = currentOrange[1];
                for (int[] dir: dirs){
                    int childRow = dir[0]+i;
                    int childCol = dir[1]+j;
                    // Check if the new children is in bounds and is still fresh
                    if(isInBounds(childRow, childCol, rows, cols) && grid[childRow][childCol] == 1){
                        // Add the fresh orange to the queue, make it rotten and reduce fresh orange count
                        queue.add(new int[]{childRow,childCol});
                        grid[childRow][childCol] = 2;
                        freshOrangeCount--;
                    }
                }

            }
        }

        return (freshOrangeCount >0) ?  -1 : minimumSeconds;
    }

    private boolean isInBounds(int childRow, int childCol, int rows, int cols) {
        if(childRow < 0 || childRow == rows) return false;
        if(childCol < 0 || childCol == cols) return false;
        return true;
    }

    /*============= DFS ============
    Time Complexity : O(MXN), M is the rows and N is the cols in the matrix
    Space Complexity : O(MXN), all M*N nodes can be in the recursion stack
    DFS: We can start from one rotten orange, go to its nearest fresh orange by incrementing the level. If the level value is
    less than the fresh orange value, we update the fresh orange value marking it as rotten. If we visit the same orange, through a
    better path with lower level value, the orange will get updated again. In this way, even if the fresh orange is many levels away
    from one rotten orange, if there exists a shorter path, the fresh orange will be visited again and updated values.
    Since the matrix has, 0, 1, 2 to represent different states, we dont want to disturb the existing state, and we will take
    offset of 2 in starting our level value. Once all the oranges are updated with their level value(minutes to rot), we will remove
    the offset of 2 and get the max minutes to rot.
    */
    public int orangesRottingDfs(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = new int[][]{{-1,0},{0,-1}, {1,0},{0,1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 2){
                    // Start dfs only from the rotten oranges with offset level by 2
                    orangesRottingRecursion(grid, directions, i, j, 2);
                }
            }
        }
        int minimumSeconds = 2;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // if still fresh orange, return -1 as not possible
                if(grid[i][j] == 1) return -1;
                minimumSeconds = Math.max(minimumSeconds, grid[i][j]);
            }
        }
        // remove the level offset value
        return minimumSeconds-2;
    }

    private void orangesRottingRecursion(int[][] grid, int[][] directions, int i, int j, int level) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(i < 0 || i >= rows) return;
        if(j < 0 || j >= cols) return;
        // Check if the new level is greater and if the cell is not fresh, then don't proceed.
        if(grid[i][j] < level && grid[i][j] != 1) return;

        grid[i][j] = level;
        // do dfs in all 4 neighbors
        for (int[] dir : directions){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            orangesRottingRecursion(grid, directions, nr, nc, level+1);
        }
    }
}
