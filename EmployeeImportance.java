

import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subs) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subs;
    }
}

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hashMap = new HashMap<>();
        for (Employee employee : employees)
            hashMap.put(employee.id, employee);

        Queue<Employee> q = new LinkedList<>();
        q.add(hashMap.get(id));
        int sum = 0;

        while (!q.isEmpty()) {
            Employee emp = q.poll();
            sum += emp.importance;
            for (int subId : emp.subordinates)
                q.add(hashMap.get(subId));
        }

        return sum;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee e2 = new Employee(2, 3, Collections.emptyList());
        Employee e3 = new Employee(3, 3, Collections.emptyList());

        List<Employee> employees = Arrays.asList(e1, e2, e3);
        EmployeeImportance sol = new EmployeeImportance();

        int result = sol.getImportance(employees, 1);
        System.out.println("Total importance for ID 1: " + result);  // Output: 11
    }
}
