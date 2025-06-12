// TC - O(M*N) -- iterate over the matrix, iterate over queue for a max of m*n times
// SC - O(M*N) -- At any point of time no more than m*n elements can be present in the queue;
// Approach -
//   Iterate over the grid and find counts of fresh and store rotten on the queue
//   Then for every rottn check its surroundings and update them accordingly, reduce fresh count
//   After every iteration increment the time.
  
  
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;
        int [][]dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;++i){
                int [] edge = q.poll();
                for(int []dir : dirs){
                    int nr = edge[0] + dir[0];
                    int nc = edge[1] + dir[1];
                    if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if(grid[nr][nc] == 1){
                        q.add(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                } 
            }
            time++;
        }
        if(fresh != 0) return -1;
        return time-1;
    }
}
