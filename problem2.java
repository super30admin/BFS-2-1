// Time Complexity: O(n)
// Space Complexity: O(n)

// Using a hashMap to access employees by their ID in O(1), and performing a dfs to compute their total importance

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> employeeMap = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {

        Employee targetEmployee = null;
        
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        return dfs(employeeMap.get(id), employees, employeeMap.get(id).importance);
    }

    public int dfs(Employee employee, List<Employee> employees, int importance) {
        for (int subordinateId : employee.subordinates) {
            Employee subordinate = employeeMap.get(subordinateId);
            importance = importance + dfs(subordinate, employees, subordinate.importance);
        }
        return importance;
    }
}
