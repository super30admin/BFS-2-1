//TC=O(n)
//SC=O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // Step 1: Build a map from id to Employee
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        // Step 2: BFS traversal
        int total = 0;
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));

        while (!queue.isEmpty()) {
            Employee current = queue.poll();
            total += current.importance;
            for (int subId : current.subordinates) {
                queue.offer(map.get(subId));
            }
        }

        return total;
    }
}