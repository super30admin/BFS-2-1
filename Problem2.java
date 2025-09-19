// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using dfs to traverse through the employee graph starting with the id. Then adding importance for every employee within the hierarchy.
 */
class Solution {
    int result;

    public int getImportance(List<Employee> employees, int id) {
        // create a map of employee by id so that we can do O(1) lookup for subordinates
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        dfs(map, id);
        return result;
    }

    private void dfs(Map<Integer, Employee> map, int id) {
        result += map.get(id).importance;
        for (int subordinate : map.get(id).subordinates) {
            dfs(map, subordinate);
        }
    }
}