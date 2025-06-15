///time complexity: O(m*n)
///space complexity: O(m*n)
///
///
///
///
///
///
///
///

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }

        }
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int minutes = 0;

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[] { nr, nc });
                    }

                }

            }
            minutes++;
        }
        if (fresh == 0) {
            return minutes;
        } else {
            return -1;
        }

    }
}

/// time complexity: O(n)
/// space complexity: O(n)
///
///
///
///
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id, map);
    }

    private int dfs(int id, Map<Integer, Employee> map) {
        Employee emp = map.get(id);
        int total = emp.importance;

        for (int subId : emp.subordinates) {
            total += dfs(subId, map);
        }
        return total;
    }
}
