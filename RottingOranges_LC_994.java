/*
BFS
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity - O(M*N)
Space Complexity - O(M*N)
*/
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_LC_994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int []> orangesQ = new LinkedList<>();
        int[][] dirs = new int[][]{{-1, 0}, {1,0}, {0, 1}, {0,-1}};
        int time = 0, freshCount = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) { //if cell is 1 increase the freshCount
                    freshCount++;
                }
                if(grid[i][j] ==2){ //if cell is 2 add it to queue for further processing
                    orangesQ.add(new int[]{i, j});
                }
            }
        }

        if(freshCount == 0) return 0; //intitaly freshcount is 0 then return 0 as nothing to rot
        int size; // to represent level in orangesQ
        while(!orangesQ.isEmpty()) {
            size = orangesQ.size();
            for(int i = 0; i< size; i++) {
                int [] curr = orangesQ.poll();
                for(int [] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    //check the Boundries on nr and nc and if its in boundary and 1 add it to queue
                    if(nr < m && nr >= 0 && nc < n && nc >= 0 && grid[nr][nc] == 1){
                        orangesQ.add(new int[]{nr,nc});
                        grid[nr][nc] = 2; // mark as rotten here itself so that we avoid duplicates in queue
                        freshCount--; // decrease fresh count
                    }
                }
            }
            time++; //increase this at every level and not node level
        }
        if(freshCount == 0) return time-1;
        // we are doing time - 1 because the last level will get processed and we still will add +1 to time
        return -1;
    }
}