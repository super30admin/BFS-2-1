
/* 
Tc: O(m *n)
SC: O(m * n)
m = number of rows and n is number of columns
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid[0].length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int level = 0;
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]== 1){
                    count++;
                }
                else if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                
            }
        }

    }
}