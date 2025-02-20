// Time Complexity : O(n) n - number of employees
// Space Complexity : O(n) using map and queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.*;
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(int i=0; i<employees.size(); i++)
            map.put(employees.get(i).id, employees.get(i));
        Queue<Employee> que = new LinkedList<>();
        que.offer(map.get(id));
        int result = 0;
        while(!que.isEmpty())
        {
            Employee e = que.poll();
            result += e.importance;

            for(int nid : e.subordinates)
                que.offer(map.get(nid));
        }

        return result;
    }
}
