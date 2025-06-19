// Time Complexity : O(n), n = employee list size adding to map
// Space Complexity : O(n), n = employee list size
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class EmployeeImportance_DFS_LC690 {
    public int getImportance(List<Employee> employees, int id) {
        // null check
        if (employees.size() == 0) return 0;

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) map.put(emp.id, emp);

        return dfs_approach(map, id);
    }

    private int dfs_approach(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int totalCount = employee.importance;

        for (int subId : employee.subordinates) {
            totalCount += dfs_approach(map, subId);  // Recursive call for each subordinate
        }

        return totalCount;
    }
}