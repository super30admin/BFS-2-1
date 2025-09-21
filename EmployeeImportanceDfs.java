//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: build a map to fetch employee information in O(1) time
//run a dfs on the given id and its subordinates to calculate the importance
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportanceDfs {

    public int getImportance(List<Employee> employees, int id) {
        final Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee: employees) employeeMap.put(employee.id, employee);

        return dfs(id, employeeMap);
    }

    private int dfs(final int id, Map<Integer, Employee> employeeMap) {

        Employee employee = employeeMap.get(id);
        int importance = employee.importance;

        for (Integer eId: employee.subordinates) {
            importance += dfs(eId, employeeMap);
        }

        return importance;
    }
}
