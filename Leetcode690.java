/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// Solution - DFS
// TC - O(n) -> Iteration 
// SC - O(n) -> Map space
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        int imp = 0;

        while(!q.isEmpty()) {
            Employee emp = q.poll();
            List<Integer> li = new ArrayList<>();
            imp += emp.importance;

            li = emp.subordinates;
            for(Integer i: li) {
                q.add(map.get(i));
            }
            
        }
        return imp;
        
    }
}