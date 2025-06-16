import java.util.*;
import java.util.LinkedList;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Intuition: use a queue to traverse the employees in a BFS manner

// BFS solution
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null)
            return -1;
        int total = 0;

        Queue<Employee> queue = new LinkedList<>();
        HashMap<Integer, Employee> hm = new HashMap<>();
        for (Employee em : employees) {
            hm.put(em.id, em);
            if (em.id == id) {
                queue.offer(em);
            }
        }

        while (!queue.isEmpty()) {
            Employee emp = queue.poll();
            total += emp.importance;
            List<Integer> subs = emp.subordinates;

            for (int subEmId : subs) {
                Employee curr = hm.get(subEmId);
                queue.offer(curr);
            }
        }

        return total;
    }
}

// DFS solution
// Time Complexity : O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Intuition: use a hashmap to store the employees and then traverse the
// subordinates recursively

class DFSSolution {
    int total = 0;
    HashMap<Integer, Employee> hm;

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null)
            return -1;
        hm = new HashMap<>();
        for (Employee em : employees) {
            hm.put(em.id, em);
        }

        for (Integer emId : hm.keySet()) {
            if (emId == id) {
                helper(hm.get(emId));
            }
        }
        return total;
    }

    public void helper(Employee em) {
        if (em == null)
            return;
        total += em.importance;
        for (Integer sub : em.subordinates) {
            Employee subEmp = hm.get(sub);
            helper(subEmp);
        }
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}
