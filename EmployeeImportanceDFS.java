// Time Complexity : O(n) where n is the number of employees in the list
// Space Complexity :   O(n) where n is the number of employees in the list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We can use a depth first search approach to solve this problem.
// We can start from the given employee id and then we can add the importance of the employee to the result and then we can call the dfs function for all the subordinates of the employee. 
// We can keep track of the importance of the employees in a map and then we can return the result at the end.
// We can also use a breadth first search approach to solve this problem. We can use a queue to keep track of the employees and then we can add the importance of the employees to the result and then we can add the subordinates of the employees to the queue. We can keep track of the importance of the employees in a map and then we can return the result at the end. DFS could also be used to solve this problem.


// Your code here along with comments explaining your approach
public import java.util.*;

import java.util.HashMap;


// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class Solution {

    Map<Integer, Employee> map;

    int result;

    public int getImportance(List<Employee> employees, int id) {

        map = new HashMap<>();

        result = 0;

        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        dfs(id);

        return result;
    }

    private void dfs(int id) {

        Employee emp = map.get(id);

        result = result + emp.importance;

        for (int ids : emp.subordinates) {
            dfs(ids);
        }
    }
} 