// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class EmployeeImpBFS {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        int result = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            Employee e = map.get(curr);
            result += e.importance;
            List<Integer> subIds = e.subordinates;
            for (int subId : subIds) {
                q.add(subId);
            }
        }
        return result;
    }
}
