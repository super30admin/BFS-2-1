/*
BFS -
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity - O(V+E)
Space Complexity - O(N) Where N is the number of Employee objects in the input list. This includes the space for the map and the queue, both of which are linear in the number of employees.

*/
import java.util.*;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class EmployeeImportance_LC_690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int result = 0;

        //iterate through employess and build a map for O(1) look up
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        //add the requested id to q and start processong its subordinates
        q.add(id);
        while(!q.isEmpty()) {
            int nbr = q.poll();
            Employee e = map.get(nbr);
            result += e.importance;

            //process id's subordinates
            for(int sId: e.subordinates)  {
                q.add(sId);
            }
        }
        return result;
    }
}

/*
DFS - Time and Space complexity - Same as per BFS
class Solution {
    int result;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();


        //iterate through employess and build a map for O(1) look up
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        dfs(id,map);
        return result;
    }
    private void dfs(int eid, Map<Integer, Employee> map) {

        //base case  , not applicable in this case

        //logic

        Employee e = map.get(eid);
        result += e.importance;
        for(int sid: e.subordinates){
            dfs(sid, map);
        }
    }
}
*/