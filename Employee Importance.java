/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    //TC = O(n)
    //SC = O(n)
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Employee> q = new LinkedList<>();
        for(Employee e: employees)
        {
            map.put(e.id, e);
        }
        q.add(map.get(id));
        int totalImportance = 0;
        while(!q.isEmpty())
        {
            Employee e = q.poll();
            totalImportance+=e.importance;

            for(int subId:e.subordinates)
            {
                q.add(map.get(subId));
            }
        }
        return totalImportance;
    }
}
