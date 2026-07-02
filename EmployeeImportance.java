/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    // TC - O(n)
    // SC - O(n)
    /*
        This solution uses DFS to calculate the total importance of an employee and all of their subordinates.
        A HashMap is first created to map each employee's ID to their Employee object, allowing O(1) lookups.
        Starting from the given employee ID, the DFS adds the employee's own importance to the total.
        It then recursively visits each subordinate and adds their importance as well.
        This process continues until all direct and indirect subordinates have been visited.
        The final result is the sum of the importance values of the employee and everyone under them.
    
     */
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return dfs(map, id);
    }

    private int dfs(HashMap<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int result = 0;
        result += e.importance;

        for (int eid : e.subordinates) {
            result += dfs(map, eid);
        }

        return result;
    }
}