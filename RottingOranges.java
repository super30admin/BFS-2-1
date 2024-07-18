// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
class RottingOranges {
    //DFS
    public int orangesRotting(int[][] grid) {
        int[][]  dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int []> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++){
                if(grid[i][j] == 1) {
                    freshCount++;
                } else if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        if(freshCount == 0) return 0;

        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] currentElement = queue.poll();
                // check all the neighbors of current Element
                for(int[] dir : dirs) {
                    int nr = currentElement[0] + dir[0];
                    int nc = currentElement[1] + dir[1];
                    // check for boundary condiions and check if neigbors are fresh
                    if(nr >= 0 && nc >=0 && nr < m && nc < n && grid[nr][nc] ==1) {
                        queue.add(new int[]{nr, nc});
                        freshCount--;
                        grid[nr][nc] = 2;
                    }
                }
            }
            time++;
        }
        if(freshCount != 0) return -1;
        return time - 1;
    }
}