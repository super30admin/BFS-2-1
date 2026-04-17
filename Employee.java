/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
TC: O(n) whre n is the number of employees
SC: O(n) for the map and the recursive stack
*/



class Solution {
    Map<Integer, Employee> map;
    int sum;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        sum = 0;
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(id);
        return sum;
    }

    private void dfs(int id){
        Employee e = map.get(id);
        sum = sum + e.importance;
        for(int eid: e.subordinates){
            dfs(eid);
        }
    }
}