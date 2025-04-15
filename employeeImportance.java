import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class  employeeImportance 
{
    class Employee 
    {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public class Solution 
    {
        public int getImportance(List<Employee> employees, int id) 
        {
            int res = 0;
            HashMap<Integer,Employee> map = new HashMap<>();
            for(int i=0;i<employees.size();i++)
            {
                Employee e = employees.get(i);
                map.put(e.id,e);
            }
            Queue<Employee> q= new LinkedList<>();
            q.add(map.get(id));
            while(!q.isEmpty())
            {
                int size = q.size();
                for(int i=0;i<size;i++)
                {
                    Employee e = q.poll();
                    res = res+e.importance;
                    if(e.subordinates !=null)
                    {
                        List<Integer> li =e.subordinates;
                        for(int j=0;j<li.size();j++)
                        {
                            q.add(map.get(li.get(j)));
                        }
                    }
                }
            }
            return res;
        }
    }
}
