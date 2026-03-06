// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to first identify the rotten orange positions and push them into queue.Now, traverse its
nieghbours using a directions array and mark those fresh oranges(if present) as rotten and push them into
queue again as they get the eligibility because of being rotten.We can keep track of fresh oranges at the
start and at end of traversal to compare and see if all fresh oranges are rotten or not.We can leverage
time variable and increment it at each level of traversal.
 */
class Solution {
    int[][] dirs;
    int m, n;
    public int orangesRotting(int[][] grid) {
        this.dirs = new int[][] {{-1,0}, {0, -1} , {1, 0}, {0, 1}};
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        this.m = grid.length;
        this.n = grid[0].length;
        int fresh = 0;

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0)
            return time;

        while(!q.isEmpty()) {
            int size = q.size();
            time++;
            for(int i = 0 ; i < size ; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                        fresh--;

                        if(fresh == 0)
                            return time;
                    }
                }

            }
        }

        return -1;
    }
}