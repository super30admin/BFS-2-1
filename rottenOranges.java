// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// 1. Traverse the grid and count fresh oranges, also add all rotten oranges to the queue initially.
// 2. Perform BFS level by level (each level = 1 minute).
// 3. For each rotten orange, rot its fresh neighbors and add them to the queue.
// 4. Keep track of time passed and decrement fresh count as oranges rot.
// 5. If fresh > 0 after BFS, return -1 (not all oranges rotted), otherwise return total time.




import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {
    public int solve(int[][] grid){
        if(grid==null || grid.length==0){
            return 0;
        }
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0, 1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]==2){
                    q.add(new int[] {i, j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0){
            return 0;
        }
        int t=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        q.add(new int[] {nr, nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }

                }

            }
            t++;
        }
        if(fresh!=0){
            return -1;
        }
        return t-1;


    }
    public static void main(String[]args){
        rottenOranges ob = new rottenOranges();
        int[][] grid1 = {{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println(ob.solve(grid1));

        int[][] grid2 = {{2,1,1}, {0,1,1}, {1,0,1}};
        System.out.println(ob.solve(grid2));





    }
    
}
