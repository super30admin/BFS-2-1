/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int totalimp = 0;
    Map<Integer, Employee> mc = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();
    public int getImportance(List<Employee> employees, int id) {
        for (int i=0;i<employees.size();i++) {
            mc.put(employees.get(i).id, employees.get(i));
        }
        System.out.println(mc);
        q.add(id);
        while (!q.isEmpty()) {
            int pollid = q.poll();
            List<Integer> sublist = mc.get(pollid).subordinates;
            totalimp = totalimp + mc.get(pollid).importance;
            for (int sb: sublist) {
                q.add(sb);
            }
        }
        return totalimp;
    }
}
class Solution {
    Queue<int[]> q= new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        int fresh=0;
        int time=0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; //U D L R

        if (grid.length == 0) {
            return -1;
        }

        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 2) {
                    int[] curr = new int[2];
                    curr[0] = i;
                    curr[1] = j;
                    q.add(curr);
                } else {
                    if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.println(size);
            for ( int i=0;i<size;i++) {
                int[] curr = q.poll();
                for (int[] dir:dirs) {
                    int nrow = curr[0] + dir[0];
                    int ncol = curr[1] + dir[1];
                    if (nrow <= m-1 && nrow >=0 && ncol <= n-1 && ncol >=0 && grid[nrow][ncol] == 1) {
                        fresh--;
                        grid[nrow][ncol] = 2;
                        q.add(new int[]{nrow, ncol});
                    }
                }
            }
            time++;
        }
        if (fresh != 0) {
            return -1;
        }
        return time-1;
        
    }
}
