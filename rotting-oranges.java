//The presence of connected components tells us a BFS or DFS can be used. BFS is natural choice over DFS for this problem (or most problems).

//Approach1:BFS Queue
//TC= O(m*n)
//SC= O(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(fresh == 0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                //neighbour
                for(int[] dir: dirs){ // 
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    //bound check
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc] == 1){
                        q.add(new int[]{nr,nc});
                        fresh--;
                        grid[nr][nc] = 2; //mark rotten
                    }
                }
            }
           time++;
        }
        if(fresh == 0) return time-1;
        return -1;
    }
}

// //Approach1:DFS Recursion
// //TC= O(m*n) amortized, worst case= O(m^2 * n^2)
// //SC= O(m*n)
// class Solution {
//     int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
//     public int orangesRotting(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(grid[i][j] == 2){
//                     dfs(grid,i,j,2);
//                 }
//             }
//         }
//         int max=2;
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(grid[i][j]==1) return -1;
//                 max=Math.max(max, grid[i][j]);
//             }
//         }
//         return max-2;
//     }
//     private void dfs(int[][] grid, int r, int c, int time){
//         //base
//         if(r < 0 || c < 0 || r == grid.length || c == grid[0].length) return;
//         if(grid[r][c] != 1 && grid[r][c] < time) return; //exception 1
//         //logic
//         grid[r][c] = time;
//         for(int[] dir: dirs){
//             int nr = dir[0] + r;
//             int nc = dir[1] + c;
//             dfs(grid, nr, nc, time + 1);
//         }
//     }
// }