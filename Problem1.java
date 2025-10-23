/*
994. Rotting Oranges
Ran on leetcode: Yes
TC: O(m * n)
SC: O(m * n)
Count all the fresh oranges, enqueue all the rotten oranges and start bfs by rotting oranges in all four directions till there are no fresh oranges remaining
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){
                if(grid[i][j] == 1){ // count the number of fresh oranges
                    fresh++;
                }
                if(grid[i][j] == 2){ // Add all the rotten orranges to the queue
                    queue.offer(new  int[]{i, j});
                }
            }
        }

        if(fresh == 0) return 0; // all the oranges are already rotten

        int time = 0;



        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            for(int i = 0; i < size; i++){
                int[] rot = queue.poll();

                //rot oranges in all four directions
                for(int[] dir: dirs){
                    int r = rot[0] + dir[0];
                    int c = rot[1] + dir[1];
                    if(r >= 0 && c >= 0 && r < rLen && c < cLen && grid[r][c] == 1){ // fresh orange and valid index
                        grid[r][c] = 2; // rot it
                        fresh--;
                        queue.offer(new int[]{r, c});
                        if(fresh == 0){ // no rotten oranges remaining
                            return time;
                        }
                    }
                }
            }
        }

        return -1;
    }
}