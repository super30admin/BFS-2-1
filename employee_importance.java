// We use BFS to traverse over the given list of employees and id to calculate important
// TC: O(n) <- as we are traversing over each employee only once
// SC: O(n) <- Queue holds n elements at once in the worst case

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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);

        for(Employee e : employees){
            map.put(e.id, e);
        }
        int total = 0;
        while(queue.size()>0){
            int currId = queue.poll();
            Employee currEmp = map.get(currId);
            total = total + currEmp.importance;
            for(int subId: currEmp.subordinates){
                queue.add(subId);
            }
        }
        return total;
    }
}
