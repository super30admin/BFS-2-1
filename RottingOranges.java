
//Using BFS Solution

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
        Queue<int []> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        if(fresh == 0)
            return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                int[] curr = q.poll();
                //neigbors
                for(int[] dir: dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    //bounds check
                    if(nr >=0 && nr <m && nc >=0 && nc < n && grid[nr][nc] == 1){
                        q.add(new int[]{nr, nc});
                        fresh--;
                        grid[nr][nc] = 2;
                    }
                }
            }
            time++;
        }
        if(fresh == 0)
            return time-1;

        return -1;
    }
}

//Using DFS Solution
//Time Complexity: O(m*n) amortised 
//Space Complexity: O(m*n)

class Solution {
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //Start DFS from each initially rotten orange

        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    dfs(grid, i ,j, 2);
                }
            }
        }
        int max = 2;
        // Check for any remaining fresh oranges and calculate max time
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    return -1; // Fresh orange not rotted
                max = Math.max(max, grid[i][j]);
            }
        }
        
        return max -2; // Subtract initial time offset
    }

    private void dfs(int[][] grid, int r, int c, int time){
        //base
        if(r<0 || c <0 || r >= grid.length || c >= grid[0].length)
            return;

         // Only update if the cell is fresh or if we can rot it faster
        if(grid[r][c] != 1 && grid[r][c] < time)
            return;

        //logic
        grid[r][c] = time;
        for(int[] dir : dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(grid, nr, nc, time+1);
        }
    }
}
