// TimeComplexity: O(m*n)
// SpaceComplexity: O(m*n)
// Explanation : I first traverse the grid to count all fresh oranges and add the positions of rotten oranges to a queue. Then I perform a BFS level by level, where each level represents one minute of time.
//  For every rotten orange, I try to rot its four neighboring cells using the direction array. Whenever a fresh orange becomes rotten, 
// I add it to the queue and decrease the fresh count. After BFS finishes, if no fresh oranges remain, I return the total time taken; otherwise, I return -1.

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int time =0;
        int oneCount = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i =0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
                if (grid[i][j] == 1) {
                    oneCount++;
                }
            }
        }
        if(oneCount ==0) {
            return 0;
        }
        int[][] dirs = {{0,-1}, {0,1}, {1,0}, {-1,0}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0; k<size; k++) {
                int[] curr = q.poll();
                for(int l =0 ; l<dirs.length; l++) {
                    int i = dirs[l][0]+curr[0];
                    int j = dirs[l][1]+curr[1];
                    if(i>=0 && j>=0 && i<m && j<n) {
                        if(grid[i][j] == 1){
                            grid[i][j] =2;
                            q.add(new int[]{i,j});
                            oneCount--;
                        }
                    }

                }

            }
            time++;
        }
        if(oneCount ==0) {
            return time-1;
        } 

        return -1;
        
    }
}
