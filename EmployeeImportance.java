//Time complexity : O(n) where m is the number of employees
//Space complexity : O(n) where m is the number of employees
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int result = 0;
    Map<Integer, Employee> idToEmployee = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {

        for (Employee employee : employees) {
            idToEmployee.put(employee.id, employee);
        }

        dfs(id);
        return result + idToEmployee.get(id).importance;
    }

    void dfs(int id) {
        if (idToEmployee.get(id).subordinates == null || idToEmployee.get(id).subordinates.size() == 0) {
            return;
        }

        for (int subId : idToEmployee.get(id).subordinates) {
            result += idToEmployee.get(subId).importance;
            dfs(subId);
        }
    }
}