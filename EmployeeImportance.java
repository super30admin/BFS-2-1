// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class EmployeeImportance {
    //BFS
    public int getImportance(List<Employee> employees, int id) {

        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        for(Employee e : employees){
            map.put(e.id, e);
        }
        queue.add(id);

        while(!queue.isEmpty()) {
            int employeeId = queue.poll();
            Employee currentEmployee  = map.get(employeeId);
            result+= currentEmployee.importance;
            // Add subordinate of the employee to the queue
            for(int subId : currentEmployee.subordinates) {
                queue.add(subId);
            }
        }
        return result;
    }

    // DFS

    class EmployeeImportance {
        //DFS
        int result;
        public int getImportance(List<Employee> employees, int id) {
            this.result = 0;
            HashMap<Integer, Employee> map = new HashMap<>();
            for(Employee e : employees){
                map.put(e.id, e);
            }
            dfs(map, id);
            return result;
        }

        private void dfs(HashMap<Integer, Employee> map, int id) {

            Employee employee = map.get(id);
            result+= employee.importance;

            for(int subId: employee.subordinates){
                dfs(map, subId);
            }
        }
    }
}