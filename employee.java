//Time Complexity: O(n) — where n is the number of employees; each employee is processed once.
//Space Complexity: O(n) — for the HashMap and the Queue.

//Store all employees in a HashMap for O(1) access by ID.
//Use a queue to perform BFS starting from the given employee ID.
//For each employee, add their importance and enqueue their subordinates.

class Solution {
    HashMap<Integer, Employee> employeeMap;

    public int getImportance(List<Employee> employees, int targetId) {
        this.employeeMap = new HashMap<>();

        // Build a map of employee ID to Employee object
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        Queue<Integer> idQueue = new LinkedList<>();
        idQueue.add(targetId);

        int totalImportance = 0;

        while (!idQueue.isEmpty()) {
            int currentId = idQueue.poll();

            Employee currentEmployee = employeeMap.get(currentId);

            totalImportance += currentEmployee.importance;

            for (int subordinateId : currentEmployee.subordinates) {
                idQueue.add(subordinateId);
            }
        }

        return totalImportance;
    }
}
