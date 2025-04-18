import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Approach -1 : BFS
public class EmployeeImportance {
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

        int res;
        HashMap<Integer, Employee> map;

        public int getImportance(List<Employee> employees, int id) {
            this.res = 0;
            this.map = new HashMap<>();

            for (Employee e : employees) {
                map.put(e.id, e);
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(id);

            while (!q.isEmpty()) {
                int currId = q.poll();
                Employee emp = map.get(currId);
                res += emp.importance;

                List<Integer> subordinates = emp.subordinates;
                for (int subId : subordinates) {
                    q.add(subId);
                }

            }
            return res;
        }
    }

// TC: O(N), SC: O(N)


//Approach - 2 : DFS
class Solution1 {
    int res;
    HashMap<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        this.res = 0;
        this.map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.id, e);
        }

        dfs(id);
        return res;
    }

    private void dfs(int id) {
        Employee e = map.get(id);
        res += e.importance;

        for (int subId : e.subordinates) {
            dfs(subId);
        }
    }
}

// TC: O(N), SC: O(N)