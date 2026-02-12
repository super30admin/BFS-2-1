/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// Approach: Employee map + BFS with queue
// TC: N for populating employeeMap + N for iterating through subordinatesQueue ~= 2N ~= O(N)
// SC: N for employeeMap + N for subordinatesQueue ~= 2N ~= O(N)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee: employees) {
            employeeMap.put(employee.id, employee);
        }
        Queue<Integer> subordinatesQueue = new LinkedList<>();
        subordinatesQueue.offer(id);
        int importance = 0;
        while (!subordinatesQueue.isEmpty()) {
            int subordinateId = subordinatesQueue.poll();
            if (employeeMap.containsKey(subordinateId)) {
                Employee employee = employeeMap.get(subordinateId);
                importance += employee.importance;
                List<Integer> subordinates = employee.subordinates;
                for (int subordinate: subordinates) {
                    subordinatesQueue.offer(subordinate);
                }
            }
        }
        return importance;
    }
}