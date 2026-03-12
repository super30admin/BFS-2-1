
    /**
    Time Complexity : O(N)
    Explanation:
    We first build a HashMap of employees in O(N).
    Then BFS traverses each employee and their subordinates once.

    Space Complexity : O(N)
    Explanation:
    HashMap stores all employees and queue stores employees during BFS traversal.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially it was difficult to access employees by their id quickly.
    Solved it by creating a HashMap that maps employee id to Employee object.
    Then used BFS starting from the given id and added the importance
    of the employee and all their subordinates.
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


    public int getImportance(List<Employee> employees, int id) {

        Queue<Integer> q = new LinkedList<>();
        int n = employees.size();

        HashMap<Integer, Employee> hmap = new HashMap<>();

        // Build id -> Employee map
        for (int i = 0; i < n; i++) {
            Employee e = employees.get(i);
            hmap.put(e.id, e);

            if (id == e.id) {
                q.add(e.id);
            }
        }

        int total = 0;

        // BFS through employee hierarchy
        while (!q.isEmpty()) {

            int curr = q.poll();
            Employee emp = hmap.get(curr);

            total += emp.importance;

            for (Integer sub : emp.subordinates) {
                q.add(sub);
            }
        }

        return total;
    }
}