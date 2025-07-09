// Time Complexity: O(N) Where N is the number of employees.
// Space Complexity: O(N) - For the HashMap to store all employees and For the Queue in the worst case.

// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - Use Breadth-First Search (BFS) to traverse through the employee hierarchy.
// - HashMap used to map employee IDs to their corresponding Employee objects for quick lookup.
// - Queue to process employees starting from the given ID.
// - For each employee, add their importance to the total sum and enqueue their subordinates.
// - Continue until there are no more employees left in the queue.

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
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,Employee> map = new HashMap<>();
        //Populate the HashMap withe all the employes( empid -> emp )
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }

        int totalImp = 0;

        //Add the given id to the queue
        q.add(id);

        while(!q.isEmpty()){
            //Get the employee
            Employee e = map.get(q.poll());
            //Add its importance
            totalImp+=e.importance;
            //Add its subordinates to the queue
            for(int sub : e.subordinates){
                q.add(sub);
            }
        }

        return totalImp;
    }
}