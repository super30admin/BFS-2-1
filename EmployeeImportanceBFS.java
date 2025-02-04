//TC: O(n)
//SC: O(n)
//approach: BFS and hashing

import java.util.*;

public class EmployeeImportanceBFS {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> emap = new HashMap<>();
        for(Employee e : employees){
            emap.put(e.id, e);
        }
        int imp = 0;
        Queue<Employee> q = new LinkedList<>();
        q.add(emap.get(id));
        while(!q.isEmpty()){
            Employee e = q.poll();
            imp += e.importance;
            for(Integer i : e.subordinates){
                q.add(emap.get(i));
            }
        }
        return imp;
    }
}

;
