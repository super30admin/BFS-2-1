/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//DFS
//TC = O(N), where N is the number of employees
//SC = O(N)
class Solution {
    int result;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(id,map);
        return result;        
    }
    private void dfs(int eid, HashMap<Integer, Employee> map){
        Employee e = map.get(eid);
        result += e.importance;
        for(int subId : e.subordinates){
            dfs(subId,map);
        }
    }
}

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// //BFS
// //TC = O(N), where N is the number of employees
// //SC = O(N)
// class Solution {
//     public int getImportance(List<Employee> employees, int id) {
//         HashMap<Integer, Employee> map = new HashMap<>();
//         for(Employee e: employees){
//             map.put(e.id, e);
//         }
//         int result = 0;
//         Queue<Integer> q = new LinkedList<>();
//         q.add(id);
//         while(!q.isEmpty()){
//             int eid = q.poll();
//             Employee e = map.get(eid);
//             result += e.importance;
//             //process the children
//             for(int sId : e.subordinates){
//                 q.add(sId);
//             }
//         }
//         return result;
//     }
// }
