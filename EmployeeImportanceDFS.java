// Time Complexity: O(N)
// - Where N is the total number of employees.
// - Each employee is visited exactly once.

// Space Complexity: O(N)
// - For the HashMap to store employee id -> employee object mappings: O(N).
// - Recursion stack can go as deep as the longest chain of subordinates: O(N) in the worst case.

// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - Use Depth-First Search (DFS) to compute the total importance of an employee and their subordinates.
// - First, build a HashMap to map employee IDs to their corresponding Employee objects for O(1) lookups.
// - Recursively add the importance of each employee and their subordinates.
// - Return the total importance.
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();
        //Populate the map
        for(Employee e : employees){
            map.put(e.id,e);
        }
        //Call dfs on the id
        return dfs(id);
    }

    private int dfs(int id){
        //Get the employee
        Employee e = map.get(id);
        //Add its importance
        int result = e.importance;
        //Call dfs on its subordinates
        for(int sub : e.subordinates){
            result+=dfs(sub);
        }
        return result;
    }
}