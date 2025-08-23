import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Idea is to use BFS - with hashmap and queue to traverse all the dependent employees and calculate cummulative importance
//Time Complexity: O(n)
//Space Complexity: O(n) 
public class EmployeeImportance {
        public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> hm =  new HashMap<Integer,Employee>();
        int imp = 0;
        for(Employee e : employees)
        {
            hm.put(e.id,e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        Integer eid;
        Employee temp;
        while(!q.isEmpty())
        {
           eid = q.poll();
           temp = hm.get(eid);
           imp += temp.importance;
           for(Integer i:temp.subordinates)
           {
            q.add(i);
           }
        }
        return imp;
    }
}
