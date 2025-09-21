//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: build a map to fetch employee information in O(1) time
//run a bfs on the given id and its subordinates to calculate the importance
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportanceBfs {

    public int getImportance(List<Employee> employees, int id) {
        final Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee: employees) employeeMap.put(employee.id, employee);

        final Queue<Employee> queue = new LinkedList<>();
        queue.offer(employeeMap.get(id));

        int importance = 0;
        while (!queue.isEmpty()) {
            final Employee employee = queue.poll();
            importance += employee.importance;

            for (Integer eId : employee.subordinates) {
                queue.offer(employeeMap.get(eId));
            }
        }

        return importance;
    }
}
