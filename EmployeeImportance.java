// TC: O(N)
// SC: O(N)
class Solution {
    HashMap<Integer, Employee> map;
    // int result;

    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();
        for(Employee emp: employees) {
            map.put(emp.id, emp);
        }

        // this.result = 0;
        return dfs(id);
        // return result;
    }

    private int dfs(int id) {
        Employee emp = map.get(id);
        int result = emp.importance;
        for(int subId : emp.subordinates) {
            result += dfs(subId);
        }

        return result;
    }
}
