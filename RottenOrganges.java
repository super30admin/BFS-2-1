package week5;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrganges {


    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1,-1}, {-1, 0}, {0, 1}, {1,0}};

        Queue<int[]> q=new LinkedList<>();
        int count=0;
        int time=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2) {
                    q.add(new int[]{i, j});
                } else {
                    if(grid[i][j]==1) {
                        count++;
                    }
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                //get neighboring orange

                for(int j=0;j<dirs.length;j++){
                    int r = dirs[j][0] + curr[0];
                    int c = dirs[j][1] + curr[1];

                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1){
                        grid[r][c] = 2;
                        count--;
                        q.add(new int[]{r, c});
                    }
                }
            }
            time++;
        }
        if(count == 0) return time-1;
        return -1;
    }
}
