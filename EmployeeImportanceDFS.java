//TC: O(n)
//SC: O(n)
//approach: DFS and hashing

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportanceDFS {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> emap = new HashMap<>();
        for(Employee e : employees){
            emap.put(e.id, e);
        }
        return dfs(emap, id);
    }

    public int dfs(Map<Integer, Employee> emap, int id){
        int imp = emap.get(id).importance;
        for(Integer sid : emap.get(id).subordinates){
            imp += dfs(emap, sid);
        }
        return imp;
    }
}
