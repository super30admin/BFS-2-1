
//using BFS
class Solution1 {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        int zeros = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j] == 0){
                    zeros++;
                }
            }
        }
        if(zeros == m*n) return 0;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] pair = queue.poll();
                for(int i = 0; i < directions.length; i++){
                    int r = pair[0] + directions[i][0];
                    int c = pair[1] + directions[i][1];

                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1){
                        queue.add(new int[]{r,c});
                        grid[r][c] = 2;
                    }

                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return -1;

                }
            }
        }
        return count-1;
    }
}
