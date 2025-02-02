import java.util.LinkedList;
import java.util.Queue;
//994. Rotting Oranges
//TC:O(m*n)
//SC: O(m*n)
class rottenOrange {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        //dirs array used to check all four directions for a given cell
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};//U D L R
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                //checking all the frsh oranges in the grid and count is stored in fresh
                if(grid[i][j]==1){
                    fresh++;
                }
                //checking for rotten and adding them to queue
                else if(grid[i][j]==2){
                    q.add(new int[] {i,j});
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        //BFS
        //Size is responsible for calculating time
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr >= 0 && nr < m && nc >=0 && nc < n && grid[nr][nc] == 1){
                        q.add(new int[] {nr,nc});
                        fresh--;
                        grid[nr][nc] = 2;
                    }
                }
            }
            time++;
        }
        if(fresh != 0){
            return -1;
        }
        return time -1;
    }
}