
/**
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if (employees.size() == 0) {
            return 0;
        }

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        int totalImportance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        while (!queue.isEmpty()) {
            int currentId = queue.poll();
            Employee emp = map.get(currentId);
            totalImportance += emp.importance;
            for (int subordinate : emp.subordinates) {
                queue.add(subordinate);
            }
        }
        return totalImportance;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
