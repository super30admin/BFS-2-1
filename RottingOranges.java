//Time complexity: O(m * n)
//Space complexity: O(m * n)

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if(m == 0 || n == 0)
            return 0;

        //Here we will use Breadth first search approach
        //We will keep track of all rotten oranges
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                //if it is rotten orange store in queue
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
                
                //at the end we should have 0 fresh oranges hence count it
                if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        //if there are no fresh oranges no point in moving further
        if(freshOranges == 0)
            return 0;

        //Now we start with BFS and go level by level. At each level we increment by 1, to keep track of time it takes to rot all oranges
        //Hence we keep track of size

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int result = 0;

        while(!q.isEmpty()) {

            int len = q.size();
            for(int i = 0; i < len; i++) {

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                //we check in all 4 directions
                for(int[] d: dir) {

                    int nr = d[0] + r;
                    int nc = d[1] + c;
                    //if it is fresh orange add in queue and mark as visited
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {

                        q.add(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                        //we dec count because we have rotten it now
                        freshOranges--;
                    }
                }
            }

            //once entire level is rotted we capture time
            result++;
        }
        
        return freshOranges == 0 ? result - 1: -1;
    }
}