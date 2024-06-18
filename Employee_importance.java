// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//Create hasp map of employee id and class employee.
//iterate over employee id and add total importance.

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//DFS
class Solution {
    HashMap<Integer, Employee> map; 
    int imp;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0){
            return 0;
        }

        map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(id);
        return imp;
    }
    private void dfs(int id){
        Employee emp = map.get(id);
        imp += emp.importance;
        
        for(int sub : emp.subordinates){
            dfs(sub);
        }
    }
}
//BFS
// class Solution {  
//     public int getImportance(List<Employee> employees, int id) {
//         // no base case needed because of for loop

//         if(employees == null || employees.size() == 0){
//             return 0;
//         }

//         Queue<Integer> q = new LinkedList<>();
//         int tot = 0;
//         HashMap<Integer, Employee> map = new HashMap<>();
//         for(Employee e: employees){
//             map.put(e.id, e);
//         }
//         q.add(id);
//         while(!q.isEmpty()){
//             int curr = q.poll();
//             Employee emp = map.get(curr);
//             tot += emp.importance;
//             if(emp.subordinates == null){
//                 continue;
//             }
//             for(int empId : emp.subordinates){
//                     q.add(empId);
//             }
//         }   
//         return tot;
//     }
// }