    /**
    Time Complexity : O(M * N)
    Explanation:
    We scan the grid once to find initial rotten and fresh oranges.
    Then each cell is processed at most once during BFS.

    Space Complexity : O(M * N)
    Explanation:
    Queue may contain many cells in worst case when oranges rot level by level.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially struggled with tracking the time correctly during BFS levels.
    Fixed it by processing the queue level by level (each level = 1 minute).
    Also needed to keep track of the number of fresh oranges so we know
    when all oranges have rotted and can return the time immediately.
    */


    class Solution {


        public int orangesRotting(int[][] grid) {
    
            int m = grid.length;
            int n = grid[0].length;
    
            // Directions: right, left, up, down
            int[][] adj = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    
            Queue<int[]> q = new LinkedList<>();
            int fresh = 0;
            int time = 0;
    
            // Step 1: Find all rotten oranges and count fresh oranges
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
    
                    if (grid[i][j] == 2) {
                        q.add(new int[]{i, j});
                    }
                    else if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }
    
            if (fresh == 0) return 0;
    
            // Step 2: BFS to rot adjacent fresh oranges
            while (!q.isEmpty()) {
    
                int size = q.size();
    
                for (int i = 0; i < size; i++) {
    
                    int[] rotten = q.poll();
    
                    for (int[] dir : adj) {
    
                        int nr = rotten[0] + dir[0];
                        int nc = rotten[1] + dir[1];
    
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
    
                            if (grid[nr][nc] == 1) {
    
                                grid[nr][nc] = 2;
                                q.add(new int[]{nr, nc});
                                fresh--;
    
                                if (fresh == 0) return time + 1;
                            }
                        }
                    }
                }
    
                time++;
            }
    
            return -1;
        }
    }