// Time Complexity : O(n)
// Space Complexity : O(n) + O(w)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Problem2 {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        ///q of eids
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        while (!q.isEmpty()) {
            Employee e = q.poll();
            result += e.importance;
            for (int subId : e.subordinates) {
                q.add(map.get(subId));
            }
        }
        return result;
    }
}
