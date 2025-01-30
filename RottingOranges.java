class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //UP, DOWN, LEFT, RIGHT
        int fresh = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();
                for(int[] row: dirs){
                    int nc = row[0] + curr[0];
                    int nr = row[1] + curr[1];
                    if(nc>=0 && nc<n && nr>=0 && nr<m && grid[nc][nr] == 1){
                        fresh--;
                        grid[nc][nr] = 2;
                        q.add(new int[]{nc, nr});
                    }
                }
            }
        }
        return fresh == 0 ? level-1: -1;
    }
}
