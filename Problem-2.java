// Time Complexity : O(N) where N is the number of employees
// Space Complexity : O(N) for the hashmap and recursion/queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach: We first create a hashmap mapping employee id to Employee object for O(1) lookups.
// Then we perform DFS or BFS starting from the given employee id, summing the importance
// of that employee and all their direct and indirect subordinates. This efficiently computes
// total importance without repeatedly scanning the employee list.

import java.util.*;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // Map id -> Employee
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        int totalImportance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);

        while (!queue.isEmpty()) {
            int currentId = queue.poll();
            Employee employee = map.get(currentId);

            totalImportance += employee.importance;

            for (int subId : employee.subordinates) {
                queue.offer(subId);
            }
        }

        return totalImportance;
    }
}
