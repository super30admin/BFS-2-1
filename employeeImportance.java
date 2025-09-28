// Time Complexity : O(N) (In the worst case each subordinate has one subordinate and we have to traverse all the employees to get the total importance value of the given employee id)
// Space Complexity : O(N) (O(N)+O(N) for hashmap and recursion stack in worst case(as explained in worst case the height of the tree can be N))
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

/**
 * The below solution uses DFS to solve the problem. We start by creating a hashmap of employee id and employee object for O(1) access to employee object using id while processing the subordinates.
 * We then call the helper function with the given id. In the helper function, we get the employee object using the id from the map and add its importance value to result.
 * We then iterate through the subordinates of this employee and call the helper function recursively for each subordinate.
 * This way we traverse all the subordinates of the given employee and add their importance values to result.
 */

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
import java.util.HashMap;
import java.util.List;


class Solution {
    int result=0;   
    HashMap<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        this.result=0;
        this.map=new HashMap<>();   
        for(Employee emp:employees)
        {
            map.put(emp.id,emp);
        }
        helper(id);
        return result;
        
    }
    private void helper(int id)
    {
        Employee emp=map.get(id);
        result+=emp.importance;
        for(int subordinate:emp.subordinates)
        {
            helper(subordinate);
        }
    }
}