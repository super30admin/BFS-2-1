/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/


// It is tree not graph. Trick is put to map for faster lookup.
// 
class Solution {

    Map<Integer, Employee> map;
    int total;

    // DFS
    // TC and SC O(n)
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        total = 0;
        map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.id, e);
        }

        dfs(id);
        return total;
    }

    private void dfs(int id) {
        Employee e = map.get(id);
        total += e.importance;

        for (int sub: e.subordinates) {
            dfs(sub);
        }

    }


    // BFS 
    // TC and SC O(n)
    public int getImportance1(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        int total = 0;
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(id);

        while(!q.isEmpty()) {
            int cur = q.poll();

            Employee e = map.get(cur);
            total += e.importance;

            for (int sub: e.subordinates) {
                q.add(sub);
            }
        }

        return total;
    }
}