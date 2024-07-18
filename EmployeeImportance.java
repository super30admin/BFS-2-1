//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    HashMap<Integer, Employee> map;
    int result;

    public int getImportance(List<Employee> employees, int id) {
        // null
        this.map = new HashMap<>();
        for (Employee emp : employees)
            map.put(emp.id, emp);

        dfs(id);

        return result;

    }

    private void dfs(int id) {
        Employee emp = map.get(id);
        result += emp.importance;
        for (int sub : emp.subordinates) {
            dfs(sub);
        }
    }
}