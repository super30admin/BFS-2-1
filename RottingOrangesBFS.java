// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
// Space Complexity: O(m * n) in the worst case (for the queue used in BFS).

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// - We use BFS (Breadth-First Search) to simulate the rotting process minute by minute.
// - First, we traverse the grid and add all initially rotten oranges to a queue.
// - At the same time, we count the number of fresh oranges.
// - Each minute, we process all the rotten oranges in the queue and try to rot adjacent fresh ones.
// - For each fresh orange that gets rotten, we reduce the fresh count and add it to the queue.
// - The process continues level by level until there are no fresh oranges left.
// - If there are still fresh oranges after the loop, we return -1. Otherwise, return the time taken minus 1,
//   since the final increment happens even if no fresh orange was rotted in that minute.

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // 4 neighbouring directions
        int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        // Queue to store the index of an orange
        Queue<int[]> q = new LinkedList<>();

        //To track the minutes
        int time = 0;
        //To keep count of fresh oranges
        int fresh = 0;

        // Find the rotten oranges in the matrix and keep count of fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i,j});
                if (grid[i][j] == 1) fresh++;
            }
        }
        // return if there are no fresh oranges to rott.
        if(fresh == 0) return time;

        //Go through the queue
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                //Pop the rotten orange from queue;
                int[] curr = q.poll();
                //check for all 4 directions
                for(int[] d: dir) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    // Check if not out of bounds and its a fresh orange
                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == 1){
                        //Make it rotten
                        grid[r][c] = 2;
                        //Add to the queue
                        q.add(new int[]{r,c});
                        //Remove it from fresh count
                        fresh--;
                        //Return the time only if all the fresh oranges are rott in the matrix.
                        if(fresh == 0) return time;
                    }

                }

            }
        }
        //Else return -1
        return -1;
    }
}