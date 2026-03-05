class Solution {
    // TimeComplexity: O(M * N)
    // SpaceComplexity: O(M * N)
    // Ran succesfully on Leetcode: yes
    public int orangesRotting(int[][] grid) {
        // keep track of the fresh oranges
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int count = 0;
        int [][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();

        // find index of rotten oranges and also count the fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // check for new rotten oranges in the queue while keeping track of the fresh count
        while(!q.isEmpty()) {
            // take a snapshot of the size of the queue
            int size = q.size();
            if(fresh == 0) return count;
            count++;
            for (int i = 0; i < size; i++) {
                int curr[] = q.poll();
                // go through all possible directions
                for (int j = 0; j < dir.length; j++) {
                    int r = curr[0] + dir[j][0];
                    int c = curr[1] + dir[j][1];
                    if (r >= 0 && c >=0 && r < m && c < n && grid[r][c] == 1) {
                        fresh--;
                        grid[r][c] = 2;
                        q.add(new int [] {r, c});
                    }

                }

            }
        }
        // if still fresh left that cant be rotten return -1
        return fresh == 0 ? count : -1;
    }
}