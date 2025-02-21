// Time Complexity: O(n)
// Space Complexity: O(n)
// Approach: BFS is used to solve this problem. The importance of the employee is added to the result and the subordinates are added to the queue.

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();

        for(Employee emp: employees){
            map.put(emp.id, emp);
        }

        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));

        int res = 0;

        while(!queue.isEmpty()){
            Employee e = queue.poll();

            res += e.importance;

            for(int subId: e.subordinates){
                queue.add(map.get(subId));
            }
        }
        return res;
    }

    // DFS
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();

        for(Employee emp: employees){
            map.put(emp.id, emp);
        }

        return dfs(map, id);
    }

    private int dfs(Map<Integer, Employee> map, int id){

        Employee emp = map.get(id);

        int result = emp.importance;

        for(int subId: emp.subordinates){
            result += dfs(map, subId);
        }
        return result;
    }
}
