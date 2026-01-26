import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
Time Complexity : O(N), N is the total number of employees
Space Complexity : O(2N), hashmap and space in the queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach :

BFS:
We can keep all the employees in a map of id and employee object for better search. We can start the search from the given employee id,
find its employees, keep them in the queue, add the parent importance will its children at different levels till we reach the leaf nodes.
*/

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            int currentEmpId = employee.id;
            employeeMap.put(currentEmpId, employee);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int importance = 0;
        queue.add(id);
        while (!queue.isEmpty()){
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                Integer currentEmpId = queue.remove();
                // Add current employee importance
                importance += employeeMap.get(currentEmpId).importance;
                // Find all subordinates to the queue to be processed
                List<Integer> empSubs = employeeMap.get(currentEmpId).subordinates;
                if(empSubs == null) continue;
                for (Integer employeeSubId : empSubs){
                    queue.add(employeeSubId);
                }
            }
        }
        return importance;
    }

    /*============= DFS ============
     Time Complexity : O(N), N is the total number of employees
     Space Complexity : O(N) + O(h), hashmap and recursion stack space(Height of employee tree)
     Approach :
     We can keep all the employees in a map of id and employee object for better search. Start depth first search on the given
     employee id, add its importance, if there are subordinates, add their importance too and call dfs on the subordinates.
    */
    public int getImportanceDfs(List<Employee> employees, int id) {
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees){
            employeeMap.put(employee.id, employee);
        }

        return getImportanceRecursive(id, employeeMap);
    }

    private int getImportanceRecursive(int id, HashMap<Integer, Employee> employeeMap) {
        // Add current employee importance
        int importance = employeeMap.get(id).importance;
        // Find all subordinates
        List<Integer> subordinates = employeeMap.get(id).subordinates;
        for(Integer sub : subordinates){
            // dfs on each subordinate and add the returned importance to parent's
            importance += getImportanceRecursive(sub, employeeMap);
        }
        return importance;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}


