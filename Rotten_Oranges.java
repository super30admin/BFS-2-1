// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only
// add rotten oranges to queue and count fresh oranges.
// while removing rotten oranges from queue, mark fresh oranges as rotten is present
// increment time for each time we come out of for loop.
 class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length; // row
        int n = grid[0].length; // col
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // U D L R
        int time = 0;
        int fresh = 0;

        for(int i = 0; i< m; i++){
            for(int j = 0; j<n ;j++){
                //  add rotten oranges to queue
                if(grid[i][j] == 2){
                    q.add(new int []{i,j});
                }
                //keep count of fresh oranges
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr []= q.poll();
                for(int[]dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >=0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new int[] {nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh != 0){
            return -1;
        }
        return --time;
    }
}