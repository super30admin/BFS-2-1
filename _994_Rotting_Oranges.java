/**** Method 1 ****/
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)

//Successfully submitted in LeetCode

//First, collect all the rotten oranges and count how many fresh ones are there. Then, every minute, rot the nearby fresh ones using BFS until none are left. If we finish rotting all, return the time; else, return -1 since some can't be reached.

import java.util.LinkedList;
import java.util.Queue;

public class _994_Rotting_Oranges {

  public int orangesRotting(int[][] grid) {
    int dir[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    int freshOrange = 0;
    int n = grid.length;
    int m = grid[0].length;
    int ans = 0;
    Queue<int[]> que = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          freshOrange++;
        } else if (grid[i][j] == 2) {
          que.add(new int[] { i, j });
        }
      }
    }

    if (freshOrange == 0) {
      return 0;
    }

    while (!que.isEmpty()) {
      ans++;
      int size = que.size();

      for (int i = 0; i < size; i++) {
        int popped[] = que.poll();
        for (int[] pos : dir) {
          int x = popped[0] + pos[0];
          int y = popped[1] + pos[1];
          if (x >= n || x < 0 || y >= m || y < 0) {
            continue;
          }
          if (grid[x][y] == 1) {
            grid[x][y] = 2;

            freshOrange--;
            que.add(new int[] { x, y });
          }

          if (freshOrange == 0) {
            return ans;
          }
        }
      }
    }

    return -1;
  }
}
