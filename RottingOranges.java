import java.util.LinkedList;
import java.util.Queue;
//tc = o(m*n) 
//sc = o(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // loop, if rotten add to queue, if fresh inc count of fresh
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    int[] arr = {i,j};
                    q.add(arr);
                }
            }
        }
        if(fresh == 0)return 0;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] current = q.remove();

                for(int[] dir:dirs){
                    int nr = current[0] + dir[0];
                    int nc = current[1] + dir[1];

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){ //check boundries and if fresh
                        grid[nr][nc] = 2;
                        fresh--;
                        int[] arr = {nr,nc};
                        q.add(arr);
                    }


                }


            }
            time++;
        }
        if(fresh == 0){
            return time -1;
        }
        else{
            return -1;
        }



    }
}