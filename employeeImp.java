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
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        int result = 0;
        q.add(id);
        while(!q.isEmpty()){
            Integer currid = q.poll();
            Employee e = map.get(currid);
            result+=e.importance;
            for(int subId: e.subordinates){
               q.add(subId);
            }
        }
        return result;
    }
}