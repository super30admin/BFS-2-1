// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/* Approach
 * We are using the BFS approach here
 * for BFS we need to find all the rotten mangos as we have to apply BFS of all the possible oranges at once
 * we loop trhough the board once to find find the and in the mean while we count the
 * fresh oranges as well
 * 
 * we add the rotten orange in the queue and start the BFS
 * for each rotten orange we check all the immitidate oranges if they are
 * fresh we rot them and add them to the queue( so that we can check their neighbours
 * in the next run ) and decrease the count of fresh orange by one
 * 
 * only we are done with one run we increase the time by one
 * 
 * in the end we check if fresh count is 0 return 0, else -1 
 */
class Solution {
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (q.isEmpty() && fresh == 0)
            return 0;
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];

                    if (nc >= 0 && nr >= 0 && nc < n && nr < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[] { nr, nc });
                        fresh--;
                    }
                }
            }
            time++;
        }
        if (fresh == 0)
            return time - 1;
        return -1;
    }
}