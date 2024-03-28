import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//tc = o(n)
//sc = o(n)
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        Queue<Employee> q = new LinkedList<>();
        Employee obj = map.get(id);
        q.add(obj);

        while(!q.isEmpty()){
            Employee current = q.remove();
            result += current.importance;

            for(int sub : current.subordinates){
                q.add(map.get(sub));
            }

        }
        return result;
        
    }
}