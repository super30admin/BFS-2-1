// Time Complexity : O(n)
// Space Complexity : O(N)
// where n is the number of the given employee + their subordinates,
// and N is the total number of employees

// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Comments in code
public class EmployeeImportance {

    // Definition for Employee.
    public class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    Map<Integer, Employee> employeeMap;
    int importance = 0;

    void dfs(int id) {
        // get the employee from the map using the ID
        Employee e = employeeMap.get(id);
        // add their importance to the total
        importance += e.importance;
        // run the DFS for each subordinate ID
        for (Integer subordinateId : e.subordinates) {
            dfs(subordinateId);
        }
    }

    public int getImportance(List<Employee> employees, int id) {
        employeeMap = new HashMap<>();
        // create a map of employee IDs to Employee
        for (Employee e : employees) {
            employeeMap.put(e.id, e);
        }
        // Do a DFS starting from the given ID
        dfs(id);
        return importance;
    }
}
