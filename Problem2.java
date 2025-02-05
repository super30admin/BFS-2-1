import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

/*
TC -> O(m*n)
SC -> O(m*n)

Using BFS approach
*/

class Solution1 {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        int importance = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while (!q.isEmpty()) {
            int curr = q.poll();
            Employee emp = map.get(curr);
            importance = importance + emp.importance;
            for (int subOrds : emp.subordinates) {
                q.add(subOrds);
            }

        }
        return importance;
    }
}