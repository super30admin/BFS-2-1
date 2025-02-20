// Rotting Oranges(https://leetcode.com/problems/rotting-oranges)

// Time Complexity : Om x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, a queue is created to store the rotten oranges. First traverse the matrix and add all rotten oranges row and col values
 * as an integer array into the queue and also keep count of fresh oranges also. While queue is not empty, first know the size 
 * and then iterate until that size and check for any rotten oranges in 4 directions and if there is one make it rotten and add
 * it to queue and after loop increase time by 1. Finally check if there are any fresh oranges, if yes return -1 else return
 * time-1 because while we check if there are any fresh oranges in last iteration it automatically increases time.
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        int [][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0; i < m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size;i++){
                int[] li = q.poll();
                int row = li[0];
                int col = li[1];
                for(int [] dir:dirs){
                    int newrow = row+dir[0];
                    int newcol = col+dir[1];

                    //bounds
                    if(newrow>=0 && newrow<m && newcol>=0 && newcol<n && grid[newrow][newcol] == 1){
                        grid[newrow][newcol] = 2;
                        fresh--;
                        q.add(new int[]{newrow, newcol});
                    }
                }
            }
            
            time++;
        }
        if(fresh!=0) return -1;
        return time-1;
    }
}