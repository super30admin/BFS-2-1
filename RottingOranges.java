import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 *
 * Approach:
 * 
 * 1. Since the neighbors are impacting its neighbors and so on, it is forming connected components, therefore it can be solved using BFS
 * 2. Find all rotten oranges and enqueue them - they are independent components. 
 * 3. While doing the above step also find all freshoranges
 * 4. If there are no freshoranges, then there is no action required
 * 5. Process each rotten orange and use a simple direction array to navigate adjacent nodes efficiently to find fresh oranges
 * 6. When all rotten oranges are done rottening fresh oranges, check if all fresh oranges are rotten and return tghe number of traversals it took
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        int min = 0;
        int[][] visited = new int[m][n];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int size1 = q.size();
            min++;
            for (int i = 0; i < size1; i++) {
                int[] curr = q.poll();
                visited[curr[0]][curr[1]] = 2;
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && visited[nr][nc] == 0) {
                        visited[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        freshOranges--;
                    }
                }

            }
        }

        if (freshOranges == 0) {
            return min - 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        // Your code here
    }
}