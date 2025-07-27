// Time Complexity : O(n)
// Space Complexity : O(n) for hashmap and queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : First create a hasmap mapping employee id tp employee id. Now Use bfs to traverse through all employees 
/// related to employee "id", add all their importances to imp variable and return it at the end
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Queue<Employee> q = new LinkedList<Employee>();
        HashMap<Integer, Employee> map = new HashMap<>();
        for(int i=0;i<employees.size();i++){
            map.put(employees.get(i).id, employees.get(i));
        }
        q.add(map.get(id));
        int imp = 0;
        while(!q.isEmpty()){
            Employee popped = q.poll();
            imp+=map.get(popped.id).importance;
            for(int subid: popped.subordinates){
                q.add(map.get(subid));
            }
        }
        return imp;
    }
}