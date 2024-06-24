// Time Complexity : o( n )
// Space Complexity : O( n ) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map; // 
    int imp;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0){
            return 0;
        }

        map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e); //putting detail - id, importance and subordinates - the whole employee object
        }
        dfs(id); // start dfs from the required id
        return imp; // total importance
    }

    private void dfs(int id){
        Employee emp = map.get(id); // getting the employee object
        imp += emp.importance;

        for(int sub : emp.subordinates){ // looping within the subordinates
            dfs(sub);
        }
    }
}