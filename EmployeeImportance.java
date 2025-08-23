// Time Complexity: O(N)
// Space Complexity: O(N)
// Did this code run on LeetCode: Yes, Accepted

// Approach:
// 1. Build a HashMap for O(1) access of employees by id. Perform BFS starting from the given employee id, 
// 2. Adding each employee’s importance to the total and enqueuing all subordinates. 
// 3. Continue until the queue is empty.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>(); // id : object

        for(Employee emp : employees){
            map.put(emp.id, emp);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        int result = 0;

        while(!q.isEmpty()){
            int currId = q.poll();
            Employee currEmp = map.get(currId);

            result = result + currEmp.importance;

            for(int subId : currEmp.subordinates){
                q.add(subId);
            }
        }
        return result;
    }
}
