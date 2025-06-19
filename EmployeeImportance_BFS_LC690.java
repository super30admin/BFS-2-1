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

class EmployeeImportance_BFS_LC690 {
    public int getImportance(List<Employee> employees, int id) {
        int totalCount = 0;
        if (employees.size() == 0) return totalCount;

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) map.put(emp.id, emp);

        Queue<Integer> queue = new LinkedList<>(); 
        queue.offer(id);

        while (!queue.isEmpty()) {
            int currId = queue.poll();
            Employee emp = map.get(currId);
            totalCount += emp.importance;

            for (int subs : emp.subordinates) {
                queue.offer(subs);
            }

        }

        return totalCount;
    }
}