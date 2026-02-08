// Time Complexity : O(n)
// Spcae Complexity: O(n)
// Explanaytion : I first store every employee in a HashMap using their id so that I can retrieve any employee in O(1) time. Then I use a queue to perform a BFS starting from the given id, adding all subordinates level by level. For each employee I dequeue, I add their importance to the total and push their subordinates into the queue.
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        q.add(id);
        int sum =0;
        while(!q.isEmpty()) {
            int currId = q.poll();
            Employee curr = map.get(currId);
            sum = sum + curr.importance;
            for(int i=0; i <curr.subordinates.size(); i++) {
                q.add(curr.subordinates.get(i));
            }
        }
        return sum;
    }
}