//TC : 
//SC :

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {

        if(grid.length==0 || grid[0].length==0||grid==null){
            return -1;

        }
        //grid length 
        int m=grid.length;//row
        int n=grid[0].length;//col
        int fresh=0;
        int time =0;
        Queue<int[]> q=new LinkedList<>();//row and col index
        
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new int []{i,j});
                }
                if(grid[i][j]==1){fresh++;}
            }
        }
if(fresh==0) return 0;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int[] crr=q.poll();
                for(int[] ff:dirs){
                    int nr=crr[0]+ff[0];
                    int nc=crr[1]+ff[1];
                    if(nr>=0 &&nr<m&&nc>=0&&nc<n&&grid[nr][nc]==1){
                        q.add(new int[]{nr,nc});
                        grid[nr][nc]=2;
                        fresh--;
                    }
                }
            }
            time++;

        }
        if (fresh!=0) {
            return -1;
        }
return time-1;

    }
}
