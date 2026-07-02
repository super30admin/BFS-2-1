// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

//Description:
// - Store all employees in a HashMap for O(1) lookup by employee ID.
// - Perform BFS starting from the given employee, accumulating importance.
// - Visit each subordinate exactly once and enqueue their subordinates for traversal.

class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for(Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);

        int importance = 0;
        while(!queue.isEmpty()) {
            int employeeId = queue.poll();
            Employee employee = employeeMap.get(employeeId);
            importance += employee.importance;

            for(int subOrdinateId : employee.subordinates) {
                queue.offer(subOrdinateId);
            }
        }

        return importance;
    }
}