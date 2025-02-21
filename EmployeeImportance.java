// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
BFS
 */

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
        int result=0;
        HashMap<Integer,Employee> emap=new HashMap<>();
        for(Employee e:employees){
            emap.put(e.id,e);
        }

        Queue<Integer> q=new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            Integer eid=q.poll();
            Employee emp=emap.get(eid);
            result+=emp.importance;
            for(Integer empid:emp.subordinates){
                q.add(empid);
            }
        }

        return result;
    }
}
