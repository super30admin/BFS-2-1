// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

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
        for(Employee e : employees){
            map.put(e.id, e);
        }
        Queue<Employee > q = new LinkedList<>();
        q.add(map.get(id));

        int result = 0;
        while(!q.isEmpty()){
            Employee e = q.poll();
            result += e.importance;
            for(int subid : e.subordinates){
                q.add(map.get(subid));
            }
        }
        return result;
    }
}