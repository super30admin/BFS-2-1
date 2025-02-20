// Employee Impotance(https://leetcode.com/problems/employee-importance/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, create a hash map with employee id as key and employee object as value. Create a queue and add the employee id given.
 * While queue is not empty, take out the value of the id given and add importance to result and for subordinates add them to
 * queue and continue until queue is empty. Finally return the result.
 */
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
/* BFS iterative solution */
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(Employee emp: employees){
            map.put(emp.id, emp);
        }
        int result = 0;
        q.add(id);
        while(!q.isEmpty()){
            Integer eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            List<Integer> subord = e.subordinates;
            for(Integer sub: subord){
                q.add(sub);
            }
        }
        return result;
    }
}

/* DFS recursive solution */
class Solution {
    int result = 0;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee emp: employees){
            map.put(emp.id, emp);
        }
        dfs(map, id);
        return result;
    }
    private void dfs(HashMap<Integer, Employee> map, int id){

        Employee e = map.get(id);
        result += e.importance;
        for(Integer subId: e.subordinates){
            dfs(map, subId);
        }
    }
}