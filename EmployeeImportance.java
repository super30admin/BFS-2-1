import java.util.*;

// BFS O(n) time, O(n) space
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee emp : employees) {
            map.put(id, emp);
        }

        int ans = 0;

        Queue<Employee> q = new LinkedList<>();
        q.offer(map.get(id));

        while (!q.isEmpty()) {
            Employee curr = q.poll();

            ans += curr.importance;
            
            for (int subId : curr.subordinates) {
                q.offer(map.get(subId));
            }
        }
        return ans;
    }
}


// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};