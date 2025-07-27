// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : for each rotten orange, check it's neighbors. If neighbor is fresh make it rotten. Initially count
/// all fresh oranges. As we rot fresh oranges decrement the count. Return the number of fresh oranges remaining

class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0, fresh = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(i);
                    q.add(j);
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(q.size()==0 && fresh == 0){
            return 0;
        }
        int directions[][] = new int[][]{{-1, 0}, {0,1}, {1,0}, {0,-1}};
        while(!q.isEmpty()){
            int size = q.size()/2;
            time++;
            for(int i=0;i<size;i++){
                int r = q.poll();
                int c = q.poll();

                for(int j=0;j<directions.length;j++){
                    int new_r = r + directions[j][0];
                    int new_c = c + directions[j][1];
                    if(new_r>=0 && new_r<m && new_c>=0 && new_c<n){
                        if(grid[new_r][new_c]==1){
                            fresh--;
                            grid[new_r][new_c] = 2;
                            q.add(new_r);
                            q.add(new_c);
                        }
                    }
                }
            }
            
        }
        if(fresh==0){
            return time-1;
        }
        return -1;
    }
}