// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

// Comments in code
public class RottingOranges {
    class Pair {
        int r, c;

        Pair(int row, int col) {
            r = row;
            c = col;
        }
    }

    Pair[] dirs = {new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1)};

    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int level = 0;
        Queue<Pair> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        int i, j;
        // traverse over the grid to
        // a) add coordinates of rotten oranges to queue
        // b) count number of fresh oranges
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        // if there are no fresh oranges, return 0
        if (fresh == 0) return 0;

        //Do a BFS starting at all of the rotten oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (i = 0; i < size; i++) {
                Pair curr = queue.poll();
                for (Pair dir : dirs) {
                    Pair neighbor = new Pair(curr.r + dir.r, curr.c + dir.c);
                    int nr = neighbor.r;
                    int nc = neighbor.c;
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        queue.add(neighbor);
                        // "rot" the fresh orange neighboring a rotten orange
                        grid[nr][nc] = 2;
                        // decrease count of fresh oranges
                        fresh--;
                    }
                }
            }
            // the level keeps track of the "layer" we're at,
            // and thus indicates the time taken to reach that layer + 1
            level++;
        }

        // if there are fresh oranges remaining, return -1
        // otherwise return level - 1
        return fresh != 0 ? -1 : level - 1;
    }
}
