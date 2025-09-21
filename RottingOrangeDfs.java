//Time Complexity : O(m x n)
//Space Complexity : O(m x n)
//Approach: Start DFS from every rotten orange and spread the rot to fresh ones with time tracking.
//Use the grid to record the time each orange became rotten.
//At the end, if any fresh orange remains, return -1, else return total time - 2 (because we start with an offset of 2 and only rot 1s)
public class RottingOrangeDfs {

    private final int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        final int row = grid.length, col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) dfs(grid, i, j, 2);
            }
        }

        int max = 2;
        for (int[] ints : grid) {
            for (int j = 0; j < col; j++) {
                if (ints[j] == 1) return -1;
                max = Math.max(ints[j], max);
            }
        }

        return max - 2;
    }

    private void dfs(int[][] grid, int i, int j, int time) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) return;
        if (grid[i][j] < time && grid[i][j] != 1) return;

        grid[i][j] = time;

        for (int[] dir: dirs) {
            final int nr = dir[0] + i, nc = dir[1] + j;
            dfs(grid, nr, nc, time + 1);
        }
    }

    public static void main(String[] args) {
        final RottingOrangeDfs rottingOranges = new RottingOrangeDfs();
        int[][] grid = new int[][] {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(rottingOranges.orangesRotting(grid)); //return -1

        grid = new int[][] {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(rottingOranges.orangesRotting(grid)); //return 4

        grid = new int[][] {{0, 2}};
        System.out.println(rottingOranges.orangesRotting(grid)); //return 0
    }
}
