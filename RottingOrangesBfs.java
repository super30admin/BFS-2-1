//Time Complexity : O(m x n)
//Space Complexity : O(m x n)
//Approach: run a bfs on every rotten orange until fresh > 0, aka all 2's initially will be at the same level,
// increment the time per level, decrease the fresh count if you find 1
//at the end if fresh > 0, return -1 else time taken
import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesBfs {

    private final int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return -1;

        final int row = grid.length, col = grid[0].length;
        final Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) queue.offer(new int[] {i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;
        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                final int[] current = queue.poll();
                for (int[] dir : dirs) {
                    final int nr = dir[0] + current[0], nc = dir[1] + current[1];
                    if (nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }
            time++;
        }

        if (fresh > 0) return -1;
        return time;
    }

    public static void main(String[] args) {
        final RottingOrangesBfs rottingOranges = new RottingOrangesBfs();
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
