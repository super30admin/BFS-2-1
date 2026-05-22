// Time Complexity : O(N)
// Space Complexity : O(N)

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> empMap = new HashMap<>();
        int totalImp = 0;

        for (Employee emp: employees) {
            empMap.put(emp.id, emp);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        while (!q.isEmpty()) {
            Employee currEmp = empMap.get(q.poll());

            totalImp += currEmp.importance;

            for (int subId: currEmp.subordinates) {
                q.add(subId);
            }
        }

        return totalImp;
    }
}