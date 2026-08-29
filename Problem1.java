//o(mxn) time complexity
//o(mxn) space complexity
//bfs



class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshOrangesCount = 0;

        for(int i = 0; i< m; i++){
            for (int j = 0; j < n ; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }

                if(grid[i][j] == 1) {
                    freshOrangesCount++;
                }
            }
        }

        if(freshOrangesCount == 0){
            return 0;
        }

        if(queue.size() == 0){
            return -1;
        }

        int minutes = -1;
        
        int[][] dirs =  {{1,0}, {-1,0},{0,-1},{0,1} };

        while(!queue.isEmpty()){
            int size = queue.size();
            minutes++;
            for(int k =0; k< size; k++){
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir: dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr < m && nc >=0 && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        freshOrangesCount--;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return freshOrangesCount == 0 ? minutes : -1;
    }
}
