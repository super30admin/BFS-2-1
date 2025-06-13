// Time Complexity O(n)
// Space Complexity O(n)
// Runs on LeetCode YES

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> row = new LinkedList<Integer>();
        Queue<Integer> col = new LinkedList<Integer>();
        int countFresh = 0;
        int time = 0;

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    row.add(i);
                    col.add(j);
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        if (countFresh == 0)
            return 0;

        while (!row.isEmpty()) {
            int size = row.size();

            for (int i = 0; i < size; i++) {
                int currRow = row.poll();
                int currCol = col.poll();

                for (int[] dir : dirs) {
                    int r = currRow + dir[0];
                    int c = currCol + dir[1];
                    if (r < grid.length && c < grid[0].length && c >= 0 && r >= 0 && grid[r][c] == 1) {
                        row.add(r);
                        col.add(c);
                        grid[r][c] = 2;
                        countFresh--;
                    }
                }
            }
            time++;
        }

        if (countFresh == 0) {
            return time - 1;
        } else {
            return -1;
        }
    }
}