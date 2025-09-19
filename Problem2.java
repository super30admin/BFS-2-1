// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// we perform BFS and add each employee and their subordinates to queue
// we use hashmap with key as emp id and value and employee object for faster lookup 
//Result will be the addition of importance of given employee and his subordinates
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
        HashMap<Integer, Employee> map = new HashMap<>();
        int result = 0;
        //put id and emp object
        for(Employee e: employees) {
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()) {
            int currEmp = q.poll(); //employee id given
            Employee emp = map.get(currEmp);
            result += emp.importance;// get the importance of curr emp
            for(int sub: emp.subordinates) {
                q.add(sub);//add the subordinates to the queue
            }
        }

        return result;
        
    }
}
