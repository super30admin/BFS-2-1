// TC: O(V+E)
// SC: O(V+E)
// Approach: Create a hashmap of employee id and employee object 
// Maintain a queue, add importance to result and process the subordinates i.e. add subordinated to queue

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class EmployeeImportance {

  static class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
      this.id = id;
      this.importance = importance;
      this.subordinates = subordinates;
    }
  };

  static int getImportance(List<Employee> employees, int id) {
    HashMap<Integer, Employee> map = new HashMap<>();
    for (Employee e : employees) {
      map.put(e.id, e);
    }
    int result = 0;
    Queue<Integer> q = new LinkedList<>();

    q.add(id);

    while (!q.isEmpty()) {
      int eid = q.poll();
      Employee e = map.get(eid);
      result += e.importance;
      // process children
      for (int sId : e.subordinates) {
        q.add(sId);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
    employees.add(new Employee(2, 3, new ArrayList<>()));
    employees.add(new Employee(3, 3, new ArrayList<>()));

    int id = 1;

    System.out.println(getImportance(employees, id));
  }
}