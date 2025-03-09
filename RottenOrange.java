/* TC O(m*n) SC O(m*n) can have max of m*n oranges in queue*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int[][] dirs = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        if(fresh == 0) return 0; //all oranges rotten
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for (int[] d : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        q.add(new int[] { nx, ny });
                    }

                }
            }
            
        }

        if(fresh!=0) return -1;
        return time-1;
    }

}