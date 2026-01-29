//TC = O(n)
//SC - O(n) 

import java.util.HashMap;
import java.util.List;

public class Problem2 {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hmap = new HashMap<>();
        for(Employee e : employees) {
            hmap.put(e.id, e);
        }

        return dfs(id, hmap);
    }

    private int dfs(int id, HashMap<Integer, Employee> hmap) {

        
        Employee e = hmap.get(id);
        int result = e.importance;
        for(Integer i : e.subordinates) {
            result += dfs(i, hmap);
        }

        return result;
    }
}
