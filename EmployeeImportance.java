/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// This solution uses a BFS approach to start with the given employee id and add the importance of that person. For each employee, we pikc the sub ordinates and add it to the queue for further importance calculation. We maintain a running importance.
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap();
        Queue<Integer> queue = new LinkedList();
        queue.add(id);

        for(Employee employee:employees) {
            map.put(employee.id, employee);
        }

        int importance = 0;
        while(!queue.isEmpty()) {
            int employeeId = queue.poll();
            Employee employee = map.get(employeeId);
            importance+=employee.importance;
            List<Integer> subordinates = employee.subordinates;
            for(int subordinate:subordinates) {
                queue.add(subordinate);
            }
        }
        return importance;
    }
}
