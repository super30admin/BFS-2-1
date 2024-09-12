import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    // BFS approach
    // TC: O(m * n) m -> number of rows  n -> number of columns
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        int[][] dirs = new int[][] {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };

        int fresh = 0, timeToRotFreshOranges = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // First step would be to scan the entire matrix and put the co-ordinates having 2 into the queue
        // 2 indicates the rotten oranges. This will be our first level to rot other oranges
        // Otherwise, if the element is 1, keep track of the number of fresh oranges
        for(int i=0; i < rows; i++) {
            for(int j=0; j < columns; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }else if(grid[i][j] == 1) {
                    fresh++;
                }// we need to skip the elements which are 0. So, checking 1 & 2 only explicitly
            }
        }

        // We didn't find any fresh orange. So, we can't rot any orange
        if(fresh == 0) return 0;

        // Now, iterate over the queue and start the BFS traversal
        while(!queue.isEmpty()) {
            // Number of elements at this level
            int size = queue.size();

            for(int i=0; i < size; i++) {
                int[] curr  = queue.poll();

                for(int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >=0 && r < rows && c >= 0 && c < columns && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }

            timeToRotFreshOranges++;

        }

        // Impossible to rot all the fresh oranges
        if(fresh != 0) return -1;


        // subtracting 1 here because for the very first element in a queue, we are incrementing this time
        // But this should be the time when we move from the root or the starting point which is 2.
        // 2 elements are already rotten. Time required will be the time once we move to the next level and start rotting the elements
        return timeToRotFreshOranges - 1;
    }
}
