// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/* Approach
 * 
 * we are using BFS to get the Importance of teh employee
 * 
 * we first create a hashmap of emp id and the employes
 * 
 * then we add the id of the givem emp
 * 
 * start the BFS add the emp importance to result and add its subordinates
 * in the queue
 * 
 * in the end we result the result
 */

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> emap = new HashMap<>();
        for (Employee ep : employees) {
            emap.put(ep.id, ep);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int result = 0;
        while (!q.isEmpty()) {
            int eid = q.poll();
            Employee cur = emap.get(eid);
            result += cur.importance;
            for (int e : cur.subordinates) {
                q.add(e);
            }
        }
        return result;
    }
}