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
    int result = 0;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        dfs(map,id);
        return result;
    }

    private void dfs(HashMap<Integer, Employee> map, int id){
        Employee e = map.get(id);
        result += e.importance;
        for(int subid : e.subordinates){
            dfs(map, subid);
        }
    }
}