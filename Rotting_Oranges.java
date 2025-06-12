// Time Complexity - O(m*n)
// Space Complexity - O(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2){
                    q.add(i);
                    q.add(j);
                }
            }
        }
        if(fresh == 0) return 0;
        if(q.size() == 0) return -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i=i+2){
                int r = q.poll();
                int c = q.poll();
                if(r + 1 < rows && grid[r+1][c] == 1){
                    q.add(r+1);
                    q.add(c);
                    fresh--;
                    grid[r+1][c] = 2;
                }
                if(c + 1 < cols && grid[r][c+1] == 1){
                    q.add(r);
                    q.add(c + 1);
                    fresh--;
                    grid[r][c+1] = 2;
                }
                if(r - 1 >= 0 && grid[r-1][c] == 1){
                    q.add(r - 1);
                    q.add(c);
                    fresh--;
                    grid[r-1][c] = 2;
                }
                if(c - 1 >= 0 && grid[r][c-1] == 1){
                    q.add(r);
                    q.add(c - 1);
                    fresh--;
                    grid[r][c-1] = 2;
                }
            }
            time++;
        }

        if(fresh != 0) return -1;

        return time-1;
    }
}
