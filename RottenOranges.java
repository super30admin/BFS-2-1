// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int minutes = -1;
    int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
    // Inserting all rotten oranges into the queue.
    Queue<int[]> queue = new LinkedList<>();
    for(int i = 0; i<m; i++) {
      for(int j  = 0; j<n; j++) {
        if(grid[i][j] == 2) queue.add(new int[]{i,j});
      }
    }
    while(!queue.isEmpty()) {
      int size = queue.size();
      for(int i = 0; i<size; i++) {
        int[] current = queue.poll();
        int x = current[0];
        int y = current[1];
        for(int[] dir: dirs) {
          int newX = x + dir[0];
          int newY = y + dir[1];
          if(newX>=0 && newX<m && newY>=0 && newY<n && grid[newX][newY] == 1) {
            grid[newX][newY] = 2;
            queue.add(new int[]{newX, newY});
          }
        }
      }
      minutes++; // Starts with -1 because the last cycle doesn't turn any fresh oranges rotten.
    }
    // Checking if any fresh oranges are left
    for(int i = 0; i<m; i++) {
      for(int j  = 0; j<n; j++) {
        if(grid[i][j] == 1) return -1;
      }
    }

    return minutes == -1? 0: minutes;
  }
}