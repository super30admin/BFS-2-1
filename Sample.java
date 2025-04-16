// Time Complexity : O(n), where n is the number of employees (each employee is visited once).
// Space Complexity : O(n) for the hashmap and queue used in BFS traversal.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We use a hashmap to map each employee's id to the corresponding Employee object for quick lookup.
// Starting from the given employee id, we perform a BFS traversal to sum the importance of the employee and all their subordinates.
// Each subordinate id is added to the queue and processed similarly until all connected employees are covered.
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        int result = 0;
        Queue<Integer> q  = new LinkedList<>();
        q.add(id);

        while(!q.isEmpty()){
            int curr = q.poll();
            Employee currObj = map.get(curr);
            result += currObj.importance;

            for(int subId: currObj.subordinates){
                q.add(subId);
            }
        }
        return result;
    }
}