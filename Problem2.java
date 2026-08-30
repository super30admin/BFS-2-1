//bfs
//o(n) space complexity
//o(n) time complexity
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {

        int impTotal = 0;

        Queue<Integer> q = new LinkedList<>();

        for(Employee emp: employees){
            map.put(emp.id, emp);
        }
        q.add(id);
        

        while(!q.isEmpty()){
            int size = q.size();
            int curr = q.poll();
            Employee currEmp = map.get(curr);
        
            impTotal = impTotal+currEmp.importance;

            for(int empId: currEmp.subordinates){
                q.add(empId);

            }
        }
        return impTotal;
    }
}
