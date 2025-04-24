package week5;

import java.util.Map;

public class EmployeeImportance {

    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id){
        this.map = new HashMap<>();
        for(Employee e: employees) {
            map.put(e.id, e);
        }
        int result = dfs(id);
        return result;
    }

    public int dfs(int id) {
        Employee emp = map.get(id);
        int result = emp.importance;

        for(int sub: emp.subordinates) {
            result += dfs(sub);
        }
        return result;
    }
}
