/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// Time complexity - O(n)
// Space complexity - O(n)
// Solved on leetcode -yes
// did you face any problem - no

// Implementing using BFS. Initially adding id to the queue, then removing id adding importance to result and adding all the subordinates that dependent on id to the queue. Processing it until q is empty()
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees) {
            map.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int result = 0;
        while(!q.isEmpty()) {
            int a = q.poll();
            result = result+map.get(a).importance;

            List<Integer> sub = map.get(a).subordinates;
            for(int i:sub) {
                q.add(i);
            }
        }
        return result;
    }
}
