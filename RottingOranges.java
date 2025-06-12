// TC: O(m*n)
// SC: O(m*n)
// Approach: Maintain a queue to add all rotten oranges 
// Create 2 variables to calculate fresh oranges and time 
// Traverse through the queue to and check all 4 neighbours 
// if orange is rotten = 2 , add in queue
// if orange is fresh = 1 , make it rotten, decrease fresh count by 1 and add it to the queue
// if there is no orange = 0, dont do anything
// repeate these steps till queue is not empty
// increase time after every level is processed 
// at the end return time - 1 if fresh count is 0 that means we could rott all oranges 
// else return -1 we could not rott all oranges

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
  static int orangesRotting(int[][] grid) {
    int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    Queue<int[]> q = new LinkedList<>();
    int fresh = 0;
    int time = 0;
    int m = grid.length;
    int n = grid[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          fresh++;
        }
        if (grid[i][j] == 2) {
          q.add(new int[] { i, j });
        }
      }
    }

    // base case
    if (fresh == 0)
      return 0;

    // logic
    while (!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        int[] curr = q.poll();
        // process neighbors
        for (int[] dir : directions) {
          int nr = dir[0] + curr[0];
          int nc = dir[1] + curr[1];
          // check bounds
          if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
            q.add(new int[] { nr, nc });
            fresh--;
            grid[nr][nc] = 2;
          }
        }
      }
      time++;
    }
    if (fresh == 0)
      return time - 1;
    return -1;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
    System.out.println(orangesRotting(grid));
  }
}