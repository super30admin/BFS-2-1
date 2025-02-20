//TC : O(n)
// SC: O(n)


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
        HashMap<Integer,Employee> map=new HashMap();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        Queue<Integer> q=new LinkedList();
        q.add(id);
        int r=0;
        while(!q.isEmpty()){
            int eid=q.poll();
            Employee e=map.get(eid);
             r+=e.importance;
            List<Integer> sID=e.subordinates;
            for(int s:sID){
                q.add(s);
            }
        }return r;
    }
}