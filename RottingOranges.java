//TC: O(r*c)
//SC: O(r*c)
//approach: BFS

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(fresh == 0) return 0;
        int level = 0;
        int[][] dirs = new int[][]{{-1,0,}, {1,0}, {0,-1}, {0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0;s<size;s++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir : dirs){
                    int nr = r+dir[0];
                    int nc = c+dir[1];
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length &&
                            grid[nr][nc] ==1){
                        fresh--;
                        q.add(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                    }
                }
            }
            level++;
        }
        if(fresh != 0){
            return -1;
        }
        return level-1;
    }
}
