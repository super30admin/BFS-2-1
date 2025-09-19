// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We use BFS approach to identify all the rotten oranges and then add them into the queue
We get the count of all the fresh oranges and maintain it globally
Process the rotten oranges in the queue and identify its neighbours if fresh then make them rotten
Maintain min time required to make fresh oranges to rotten and return the time when no more fresh oranges are left else return -1
*/
class Solution {
    int dirs[][];
    public int orangesRotting(int[][] grid) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int []> q = new LinkedList<>();
        int n = grid.length; //row length
        int m = grid[0].length; // column length
        int fresh = 0;
        int time = 0;
        //get the count of fresh oranges
        for(int i = 0; i< n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == 1) {
                    fresh += 1;
                } else if(grid[i][j] == 2) { //rotten oranges will be pushed to queue
                    q.add(new int[]{i, j});
                }
            }
        }

        // no fresh oranges 
        if(fresh == 0) return 0;
        //process the queue
        while(!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0;i<size; i++) {
                int[] cur = q.poll();
                for(int[] dir: dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    //bounds check and check for fresh oranges
                    if (r>=0 && c>=0 && r<n && c<m && grid[r][c] == 1) {
                        //make it rotten
                        grid[r][c] = 2;
                        fresh--;
                        //add it to the queue
                        q.add(new int[]{r, c});
                    }
                }
            }
            if(fresh == 0) return time;
        }
        return -1;
    }
}
