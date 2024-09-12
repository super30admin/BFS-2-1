import java.util.*;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class EmpImportance {

    // TC: O(n) n => number of subordinates because if are given a id of the root, we need to iterate over all the employees
    // SC: O(n) We are putting elements in a map
    // Using BFS approach
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;

        map =new HashMap<>();

        // First create a map of Employee ID and the employee object
        // This will help us later to lookup a ID and a list of it's sub-ordinates in a constant time
        for(Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int totalImportance = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            totalImportance += map.get(current).importance;

            List<Integer> subordinates = map.get(current).subordinates;
            for(int subordinate : subordinates){
                queue.add(subordinate);
            }
        }

        return totalImportance;
    }

    // TC: O(n) - Same as above
    // SC: O(n)
    int total = 0;
    public int getImportance_DFS(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;

        map = new HashMap<>();

        // First create a map of Employee ID and the employee object
        // This will help us later to lookup a ID and a list of it's sub-ordinates in a constant time
        for(Employee employee : employees) {
            map.put(employee.id, employee);
        }
        dfs(id);
        return total;
    }

    private void dfs(int id) {

        total += map.get(id).importance;

        List<Integer> subordinates = map.get(id).subordinates;
        for(int subordinate : subordinates) {
            dfs(subordinate);
        }
    }
}
