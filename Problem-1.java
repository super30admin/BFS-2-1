// Time Complexity : O(mn) for BFS, O(mn) for dfs too, by code it look m^2n^2 but as 
// soon as first dfs all the nodes become rotten and second after iteration befores very effecient.
// Space Complexity : O(mn) for both dfs and bfs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public int orangesRottingBfs(int[][] grid) {
        int[][] dirs = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
        int fresh = 0;
        int r = grid.length;
        int c = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < r; i++){
            for(int j =0;j<c;j++){
                if(grid[i][j] == 2){
                    q.add(new int []{i,j});
                }else if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int [] cur = q.poll();
                for(int [] dir: dirs){
                    int nr = cur[0] + dir[0] ;
                    int nc = cur[1] + dir[1];
                    if(nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new int []{nr,nc});
                        fresh--;
                        if(fresh == 0) return time + 1;
                    }
                }
            }
            time++;  
        }
        return -1;
    }

    int[][] dirs = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i =0;i < m;i++){
            for(int j =0;j < n;j++){
                if(grid[i][j] == 2){
                    dfs(grid,i,j,m,n,2);
                }
            }
        }

        int max = 0;
        for(int i =0;i < m;i++){
            for(int j =0;j < n;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
                max = Math.max(max, grid[i][j]);
            }
        }
        if(max == 0) return 0;
        return max - 2;
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, int time){
        //base 
        if(i < 0 || j < 0 || i == m || j == n) return;
        if(grid[i][j] != 1 && grid[i][j] < time) return;
        
        //logic
        grid[i][j] = time;

        //neighboring tomatoes
        for(int [] dir: dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid,nr,nc,m,n,time + 1);
        }
    }
}