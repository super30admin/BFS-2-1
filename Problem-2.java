// Time Complexity : O(V + E)
// Space Complexity : O(V) as I store node and its referece
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportancebfs(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee em: employees){
            map.put(em.id, em);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int res = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            Employee curE = map.get(cur);
            res = res + curE.importance;
            List<Integer> subs = curE.subordinates;
            for(Integer sub: subs){
                q.add(sub);
            }
        }
        return res;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee em: employees){
            map.put(em.id, em);
        }

        return dfs(map, id);
    }

    private int dfs(HashMap<Integer, Employee> map, int id){
        int re = map.get(id).importance;
        for(int sub: map.get(id).subordinates){
            re += dfs(map, map.get(sub).id);
        }
        return re;
    }
}