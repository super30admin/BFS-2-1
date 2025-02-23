//time complexity: O(n) where n is the number of nodes
//Space complexity: O(n) worst case we need to save all leaf nodes which is n/2

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));

        int total = 0;
        while(!queue.isEmpty()) {
            Employee emp = queue.poll();
            total = total + emp.importance;
            for(int sub : emp.subordinates) {
                queue.offer(map.get(sub));
            }
        }
        return total;
    }
}
