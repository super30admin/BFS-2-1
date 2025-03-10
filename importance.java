/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// TC: O(N)

class Solution {
    int result;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        dfs(map,id);
        return result;
    }
    private void dfs(HashMap<Integer, Employee> map, int id){
        Employee e = map.get(id);
        result+=e.importance;
        for(int sub:e.subordinates){
            dfs(map, sub);
        }
    }
}