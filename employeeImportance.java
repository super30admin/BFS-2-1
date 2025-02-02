import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

//690. Employee Importance
//TC: O(n)
//SSC: O(n)
class employeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null){
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        int total = 0;
        HashMap<Integer,Employee> map = new HashMap<> ();
        //using map for faster lookup from line 28
        for(Employee e : employees){
            map.put(e.id,e);
        }
        q.add(id);
        //BFS
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee emp = map.get(curr);
            total = total+ emp.importance;
            for(int sub : emp.subordinates){
                q.add(sub);
            }
        }
        return total;
    }
}

//DFS solution.
class Solution {
    HashMap<Integer,Employee> map;
    int total;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null){
            return 0;
        }
        total = 0;
        map = new HashMap<> ();
        //using map for faster lookup from line 28
        for(Employee e : employees){
            map.put(e.id,e);
        }
        //DFS
        dfs(id);

        return total;
    }
    private void dfs(int id){
        //base
        //logic
        Employee emp = map.get(id);
        total = total + emp.importance;
        for(int sub : emp.subordinates){
            dfs(sub);
        }
    }
}