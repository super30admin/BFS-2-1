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

//BFS soln

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        int result = 0;
		//Iterate over the list and add the employee obj to hasmmap
        for(Employee e: employees){
            map.put(e.id, e);
        }
		
		//BFS to get the result
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int empId = q.poll();
            result += map.get(empId).importance;
            for(int eId: map.get(empId).subordinates){
                q.add(eId);
            }
        }
        return result;
    }
}