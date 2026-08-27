// Note: Repeated subproblems - Dynamic Programming, Connected components - DFS, BFS
// Approach: Using directions array and couple of variables, traverse the entire matrix
// Until all the fresh oranges are rotten and return time
//Time Complexity- O(mxn)
//Space Complexity-O(mxn)
class RottenOranges {
    int m, n;
    int[][] dirs;
    public int orangesRotting(int[][] grid) {

        this.m = grid.length;
        this.n = grid[0].length;

        this.dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;

        // Iterate through the entire matrix to identiy rotten oranges and add them to the queue.
        // At the same time keep a count of fresh oranges
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new int[]{i, j});
                }
                else if (grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }

        // If there are no fresh oranges, we can return the time right away (0 minutes)
        if(fresh == 0) return time;

        // Perform BFS using directions array and check for fresh oranges beside the rotten oranges.
        // Then make the rotten orange as fresh orange and decrease the fresh count
        // At each cycle, increment the time until queue is empty.
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                int[] curr = q.poll();
                for(int[] dir: dirs)
                {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1)
                    {
                        q.add(new int[] {r, c});
                        grid[r][c] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }

        // At the end, if fresh count becomes 0 then return time
        if (fresh == 0) return time-1;
        return -1;
    }
}