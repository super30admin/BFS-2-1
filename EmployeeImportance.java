import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time Complexity: O(n), where n is the number of employees.
 * Space Complexity: O(N) where N is the total number of employees
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Do a BFS/DFS to find the importance of all employees
 */

public class EmployeeImportance {
    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        Employee(int id, int imp, List<Integer> sub) {
            this.id = id;
            this.importance = imp;
            this.subordinates = sub;
        }
    }

    // ------------------------------------------ BFS approach ------------------------------------------
    public int getImportance(List<Employee> employees, int id) {
        int impValue = 0;

        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }

        if (!map.containsKey(id)) {
            return 0;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        while(!q.isEmpty()) {
            int curr = q.poll();
            Employee emp = map.get(curr);
            impValue += emp.importance;

            for (int e: emp.subordinates) {
                q.add(e);
            }
        }

        return impValue;
    }

    // ------------------------------------------ DFS approach ------------------------------------------
    HashMap<Integer, Employee> map;
    public int getImportance2(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }

        if (!map.containsKey(id)) {
            return 0;
        }

        return dfs(id);
    }

    private int dfs(int id) {
        Employee e = map.get(id);
        int imp = e.importance;
        for (int em: e.subordinates) {
            imp += dfs(em);
        }

        return imp;
    }

    public static void main(String[] args) {
        // Your code here
        Employee e1 = new Employee(1, 5, List.of(2,3));
        Employee e2 = new Employee(2, 3, new ArrayList<>());
        Employee e3 = new Employee(3, 3, new ArrayList<>());
        List<Employee> emp = new ArrayList<>(List.of(e1,e2,e3));
        EmployeeImportance obj = new EmployeeImportance();

        int importance = obj.getImportance(emp, 2);
        System.out.println(importance);
        assert (importance == 3);

        importance = obj.getImportance2(emp, 1);
        System.out.println(importance);
        assert (importance == 11);
    }
}