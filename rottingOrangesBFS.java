// Time Complexity : O(m*n) m == grid.length, n == grid[i].length
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dirs is to check for all 4 immediate neighbors
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        //fresh denotes the count of fresh oranges, we maintain this count
        //to keep track of all the possible oranges that can get rotten
        int fresh = 0;

        for(int i = 0; i< m;i++){
            for(int j = 0;j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int time = 0;
        while(!(q.isEmpty())){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    //bounds check
                    if(nr >=0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new int[] {nr,nc});
                        fresh--;
                        if(fresh == 0) return time+1;
                    }
                }
            }
            time++;
        }
        //if(fresh != 0)
        return -1;
    }
}