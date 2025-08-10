/*
 * TC: O(m*n) where m = no of rows, n: no of columns.
 * SC: O(m*n) max size of queue in worst case where each and every element would be in the queue.
 * 
 * Approach: initially, i will add all the rotten oranges in the queue. then i keep doing BFS on each of the grid in my queue
 * and pop the same from the queue.keep chekcing all the direction of the rotten orange. and also keep rotting the fresh oranges on the go 
 * and also keep counting the conversions.
 */


class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0,fresh = 0;
        Queue<int[]> q = new LinkedList<>();

    for(int i  = 0; i <grid.length; i++){
        for(int j =0; j<grid[0].length; j++){
            if(grid[i][j] == 2)
                q.add(new int[] {i,j});
            if(grid[i][j] == 1)
                fresh++;
        }
    }
    return helper(grid, fresh,time,q);
    }


    private int helper(int[][] grid, int fresh, int time, Queue<int[]> q){

        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;
            for(int i =0; i< size; i++){
                int[] curr = q.poll();

                int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};

                for(int[] dir : dirs){
                    int newi = dir[0] + curr[0];
                    int newj = dir[1] + curr[1];

                    if(newi >= 0 && newj >= 0 && newi < grid.length && newj < grid[0].length && grid[newi][newj] == 1){
                        fresh--;
                        q.add(new int[] {newi,newj});
                        grid[newi][newj] = 2;
                        rotted = true;
                    }
                }
            }
            if(rotted) time++;
            if(fresh == 0) return time;
        }
    return (fresh != 0) ? -1 : time;
    }
}