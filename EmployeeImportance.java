// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Feed the combination of employee id and their respective object into a map for optimized search. Now, have
a queue to start with the given input employee and then iteratively traverse all his subordinates by
summing up the importance at each traversal and we can return it.
 */
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        int totalImportance = 0;

        while(!q.isEmpty()) {
            Employee e = q.poll();
            totalImportance += e.importance;
            if(e.subordinates != null) {
                for(int subordinate : e.subordinates) {
                    q.add(map.get(subordinate));
                }
            }
        }
        return totalImportance;
    }
}