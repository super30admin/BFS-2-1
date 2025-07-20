//TC :O(n × m)
//SC: O(n × m)

class Solution {
    public int orangesRotting(int[][] grid) {
      int row =  grid.length;
      int col =  grid [0].length;
      Queue<int[]> queue=new LinkedList<>();
      int fresh=0;
      for( int r=0;r<row;r++){
        for(int c=0;c<col;c++){
         if (grid[r][c]==2){
          queue.add(new int[]{r,c});  
         }
         else if(grid[r][c]==1){
         fresh++;
         }
        }
      }
      
      if(fresh==0){
        return 0;
      }
        int minutes = 0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // Step 2: BFS from rotten oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infected = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];

                    // If adjacent is fresh, rot it
                    if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // rot it
                        fresh--;
                        queue.offer(new int[]{nr, nc});
                        infected = true;
                    }
                }
            }

            if (infected) minutes++;

        }
     return fresh == 0 ? minutes : -1;
    }
}