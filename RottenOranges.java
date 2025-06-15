class Solution {
    //BFS -> only reason we are using connected component
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        int fresh = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {

                    q.add(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int time = 0;
        if (fresh == 0)
            return 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                //neighbor 

                for (int[] dir : dirs) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    //bounds check 
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        q.add(new int[] { nr, nc });
                        fresh--;
                        grid[nr][nc] = 2;
                    }
                }
            }
            time++;
        }

        if (fresh == 0)
            return time - 1;

        return -1;

    }

    //DFS

}