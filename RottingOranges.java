// Time Complexity : O(m*n).
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Approach : We perform BFS here to achieve the result. First, we capture 2's so that we get the starting point to navigate to neighbors and 1's to get a
// count of fresh ones present. We traverse each level and explore it's neighbors, if we find fresh make it rotten and add to the queue so that a fresh
// one is not visited twice. Finally when we reach fresh == 0, that means rotting process is complete amd resturn result.

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; //neighbors directions
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j }); //capture 2's in queue;
                }
                if (grid[i][j] == 1) {
                    fresh++; //1's count
                }
            }
        }
        if (fresh == 0) {
            return 0; // no fresh ones
        }

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : directions) { //each level traversal
                    int topDown = curr[0] + dir[0];
                    int leftRight = dir[1] + curr[1];
                    if (leftRight >= 0 && topDown >= 0 && leftRight < n && topDown < m
                            && grid[topDown][leftRight] == 1) { //bounds and fresh check
                        grid[topDown][leftRight] = 2; //make it rotten
                        queue.add(new int[] { topDown, leftRight }); // add to the queue
                        fresh--; //decrement fresh
                        if (fresh == 0) //fresh are done
                            return result+1;
                    }

                }
            }
            result++;

        }
        return -1;
    }
}