// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

// Approach: BFS is used to solve this problem. The rotten oranges are added to the queue and then the adjacent fresh oranges are rotten and added to the queue.

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }

        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i = 0; i < size; i++){
                int[] elem = queue.poll();


                for(int[] dir: dirs){
                    int nr = elem[0] + dir[0];
                    int nc = elem[1] + dir[1];

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
        }

        if(fresh != 0){
            return -1;
        }
        return count-1;
    }
}
