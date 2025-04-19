import java.util.*;

// Time complexity - O(N)
// Space complexity - O(N) for the hashmap storing employee information
// LeetCode: https://leetcode.com/problems/employee-importance/

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class EmployeeImportance {
    int result;
    HashMap<Integer, Employee> eMap;

    public int getImportance(List<Employee> employees, int id) {
        this.result = 0;
        eMap = new HashMap<>();

        for (Employee e : employees) {
            eMap.put(e.id, e);
        }
        dfs(id);
        return result;
    }

    public void dfs(int id) {
        Employee e = eMap.get(id);
        result += e.importance;

        for (Integer subOrdinateid : e.subordinates) {
            dfs(subOrdinateid);
        }
    }
}
