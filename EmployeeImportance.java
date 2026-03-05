
class Solution {
    // TimeComplexity: O(N)
    // SpaceComplexity: O(N)
    // Ran succesfully on Leetcode: yes
    public int getImportance(List<Employee> employees, int id) {
        int total = 0 ;
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Employee> q = new LinkedList<>();
        // map add all ids to respctive Employee object
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        q.add(map.get(id));
        // iterate till they are no more subordinates linked to employee
        while(!q.isEmpty()) {
            Employee curr = q.poll();
            total = curr.importance + total;
            // add curr empl subordinates to the queue
            for (int sub:curr.subordinates) {
                q.add(map.get(sub));
            }
        }
        return total;
    }
}