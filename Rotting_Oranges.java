

/* ---- approach : Use BFS (Breadth-First Search) starting from all initially rotten oranges, spreading the rot level by level to adjacent fresh oranges, and track the time taken for all to rot.
If any fresh oranges remain after BFS, return -1, else return the total minutes elapsed
---- */  

// time complexity : O(m × n)
 // Space: O(m × n)

class Solution {
    int[][] dirs;
    int m, n;
    public int orangesRotting(int[][] grid) {
        this.dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        this.m = grid.length;
        this.n = grid[0].length;
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int time = 0;
        if(fresh == 0) return time;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();
                for(int[] dir: dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh == 0) {
            return time - 1;
        }
        return -1;
    }
}
