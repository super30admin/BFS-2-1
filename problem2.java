import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.List;
public class problem2 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    HashMap<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while (!q.isEmpty()) {
            int currId = q.poll();
            Employee currEmp = map.get(currId);
            result += currEmp.importance;
            for (int subIds : currEmp.subordinates) {
                q.add(subIds);
            }
        }
        return result;
    }
}