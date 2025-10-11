
/* ----Store all employees in a HashMap for quick lookup, then use DFS to recursively add each employee’s importance along with all their subordinates’ importance.----- */

// time : O(N) Space : O(N)




class Solution {
    HashMap<Integer, Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();

        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        this.result = 0;
        dfs(id);
        return result;
        
    }

    private void dfs(int id) {
        Employee emp = map.get(id);

        result += emp.importance;

        for(int subId : emp.subordinates) {
            dfs(subId);
        }


    }
}
