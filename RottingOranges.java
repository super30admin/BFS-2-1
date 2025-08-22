// This solution uses BFS approach where we first get indices of all the rotten oranges and put it in queue. At each minute or level we pick all the rotten oranges and put adjacent valid indices  into the queue for next day.c
class Solution {
    int[][] indices = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        int freshOranges = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==2) queue.add(new int[]{i, j});
                else if(grid[i][j]==1) freshOranges++;
            }
        }
        if(freshOranges==0) return 0;

        int minutes = 0;
        while(!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] refIndex = queue.poll();
                for(int[] index:indices) {
                    int r = index[0]+refIndex[0];
                    int c = index[1]+refIndex[1];

                    if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]==0 || grid[r][c]==2) {
                        continue;
                    } else {
                        queue.add(new int[]{r,c});
                        grid[r][c] = 2;
                        freshOranges--;
                        if(freshOranges==0) return minutes;
                    }
                }
            }
        }
        if(freshOranges!=0) return -1;
        return minutes;
    }
}
