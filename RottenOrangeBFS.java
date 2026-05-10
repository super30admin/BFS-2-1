// Time Complexity :  O(m*n) where m is the number of rows and n is the number of columns in the grid
// Space Complexity :   O(m*n) where m is the number of rows and n is the number of columns in the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//No
// Your code here along with comments explaining your approach
// We can use a breadth first search approach to solve this problem.
//  We can start from all the rotten oranges and then we can rot the adjacent fresh oranges.
//  We can keep track of the time taken to rot all the oranges and return the time taken at the end. 
// If there are still fresh oranges left, we can return -1.
// We can use a queue to keep track of the rotten oranges and a variable to keep track of the time taken to rot all the oranges.
// We can also keep track of the number of fresh oranges and decrement it every time we rot a fresh orange.
//  DFS could also be used to solve this problem.

// Your code here along with comments explaining your approach
import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        int[][] directions = new int[][]
        {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        Queue<int[]> que = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    que.offer(new int[] { i, j });
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int time = 0;

        while (!que.isEmpty() && fresh > 0) {

            int size = que.size();

            for (int i = 0; i < size; i++) {

                int[] curr = que.poll();

                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) {

                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;
                        que.offer(new int[] { nr, nc });
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}