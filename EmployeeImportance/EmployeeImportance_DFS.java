/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

/* Time Complexity : O(V+E) ~ O(n) , as V=E
 * 	n - length of the input list - employees */
/* Space Complexity : O(n) 
 * size of the hashmap */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//DFS soln

class Solution {
    int result;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        result = 0;
        for(Employee e: employees){
            map.put(e.id, e);
        }

        dfs(map, id);

        return result;
    }

    private void dfs(HashMap<Integer, Employee> map, int id){
        //logic
        Employee e = map.get(id);
        result += e.importance;
        for(int eId: e.subordinates){
            dfs(map, eId);
        }
    }
}