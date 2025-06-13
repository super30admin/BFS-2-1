// Time Complexity O(n)
// Space Complexity O(n)
// Runs on LeetCode YES

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
        Queue<Integer> q = new LinkedList<Integer>();
        int result = 0;

        for (Employee e : employees) {
            map.put(e.id, e);
        }
        q.add(id);
        while (!q.isEmpty()) {
            int currentID = q.poll();
            Employee currEmployee = map.get(currentID);
            result = result + currEmployee.importance;
            for (Integer subordinate : currEmployee.subordinates) {
                q.add(subordinate);
            }
        }
        return result;
    }
}