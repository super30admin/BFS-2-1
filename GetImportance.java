// Problem 690. Employee Importance
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class GetImportance {
    int re;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(id, map);
        return re;
    }
    private void dfs(int id, HashMap<Integer, Employee> map){
        Employee e = map.get(id);
        re += e.importance;
        for(int subId: e.subordinates){
            dfs(subId, map);
        }
    }
}