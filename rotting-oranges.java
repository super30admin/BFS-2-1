//time complexity O(m*n) as we iterate over the entirity of the array
//Space complexity is O(m*n) as the queue can hold the whole grid if all oranges are rotten

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0){
            return -1;
        }

        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0 ; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        int count = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int[] dir : dirs) {
                    int nr = rotten[0] + dir[0];
                    int nc = rotten[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        fresh--;
                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            count++;
        }
        return fresh == 0 ? count == 0 ? count : count - 1 : -1;
    }
}
