/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> m = new HashMap<>();
        for(Employee e: employees)
        {
            m.put(e.id,e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int res=0;
        while(!q.isEmpty())
        {
            int eid= q.poll();
            Employee e =m.get(eid);
            res +=e.importance;
            List<Integer> subIds = e.subordinates;
            for(int subId: subIds)
            {
                q.add(subId);
            }
        }
        return res;
    }
}
//tc: O(n)
//sc: O(n)
//where is the no of employees