//Time Complexity- O(n) where n is the number of employees
//Space Complexity- O(n) where n is the  hashmap space and the recursive stack
import java.util.*;
public class EmployeeImportance {
    static class Employee {
        int id;
        int importance;
        List<Integer> subordinates;
        Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
    static int value = 0;
    static int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id, e);
        }

        dfs(map.get(id), map);

        return value;
    }

    static void dfs(Employee e, HashMap<Integer, Employee> map) {

        value += e.importance;
        for(int id : e.subordinates) {
            dfs(map.get(id), map);
        }
    }
    public static void main(String[] args) {
        Employee e1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee e2 = new Employee(2, 3, new ArrayList<>());
        Employee e3 = new Employee(3, 3, new ArrayList<>());
        List<Employee> employees = Arrays.asList(e1, e2, e3);
        int id = 1;
        System.out.println("Total importance od id " + id + " is: " + getImportance(employees, id));
    }
}
