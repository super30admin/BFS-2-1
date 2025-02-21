// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
BFS
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        int fresh=0;

        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int time=0;
        q.offer(new Pair(-1,-1));
        int[][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(!q.isEmpty()){
            Pair<Integer, Integer> p=q.poll();
            int r=p.getKey();
            int c=p.getValue();
            if(r==-1){
                time++;
                if(!q.isEmpty())
                    q.offer(new Pair(-1,-1));
            } else {
                for(int[] d:dir){
                    int nr=d[0]+r;
                    int nc=d[1]+c;
                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.offer(new Pair(nr,nc));
                        fresh--;
                    }
                }
            }
        }

        return fresh==0?time-1:-1;


    }
}