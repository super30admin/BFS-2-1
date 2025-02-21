// Time Complexity :O(m+n)
// Space Complexity :O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach in three sentences only:BFS approach where i process all rotten oranges for the first,first i find rotten oranges from given matrix and i put them in queue in addition to that i have counted fresh oranges
//   then i process the queue by polling rottan ornage from queue and adding 4 adjacents to queue and reducing count and after each level incrementing time by one to track of time
//in final if i find fresh coount as zero then i return the time-1;
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
           int time=0;
           int fresh=0;
           for(int i=0;i< m;i++){
             for(int j=0;j< n;j++){
               if(grid[i][j] == 2){
                q.add(new int[]{i,j});
               }else if(grid[i][j] == 1){
                fresh++;
               }
           } 
    }
    if(fresh == 0)return 0;
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    while(!q.isEmpty()){
              int size=q.size();
              for(int i=0;i<size;i++){
                int[] pair=q.poll();
                for(int[] dir:dirs){
                   int cr=pair[0]+dir[0];
                   int cc=pair[1]+dir[1];
                   while(cr >= 0 && cr < m && cc >= 0 && cc < n && grid[cr][cc] ==1 ){
                    q.add(new int[]{cr,cc});
                    grid[cr][cc] = 2;
                    fresh--;
                   }
                }
              }  
               time++;    
    }
    if(fresh != 0) return -1;
    return time-1;
    }

}