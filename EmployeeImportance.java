// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// 1. Put all employees into a HashMap<id, Employee> for quick lookup.
// 2. Start BFS from the given employee id using a queue.
// 3. For each employee we dequeue:
//      - add their importance to total
//      - enqueue all their subordinates
// 4. Repeat until queue is empty.
// 5. Return the total importance.








import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


public class EmployeeImportance {
    public int solve(List<Employee> employees, int id){
        if(employees == null || employees.size()==0){
            return 0;
        }

        HashMap<Integer, Employee> hm = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        int t=0;

        for(Employee e : employees){
            hm.put(e.id, e);
        }
        q.add(id);
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee e = hm.get(curr);
            t = t + e.importance;
            for(int sub : e.subordinates){
                q.add(sub);
            }
        }
        return t;

    }

    public static void main(String[]args){
        EmployeeImportance ob = new EmployeeImportance();
        Employee e1 = new Employee();
        e1.id = 1; e1.importance = 5; e1.subordinates = Arrays.asList(2, 3);
        Employee e2 = new Employee();
        e2.id = 2; e2.importance = 3; e2.subordinates = new ArrayList<>();
        Employee e3 = new Employee();
        e3.id = 3; e3.importance = 3; e3.subordinates = new ArrayList<>();
        List<Employee> list = Arrays.asList(e1,e2,e3);
        System.out.println(ob.solve(list, 1));



    }
    
}
