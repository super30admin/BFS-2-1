/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
/*
690. Employee Importance
Ran on leetcode: Yes
TC: O(n)
SC: O(n)
Add the employee to the queue and then add all it subordinates to the queue and so on and add up all their importance on the way
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        // For easier search
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee: employees){
            map.put(employee.id, employee);
        }

        Queue<Integer> queue = new LinkedList<>();
        // add the employee
        queue.offer(id);

        int result = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int currEmp = queue.poll();
            // process the employee
            Employee emp = map.get(currEmp);

            result += emp.importance;

            // add all the subordinates to the queue
            for(int sub: emp.subordinates){
                queue.offer(sub);
            }
        }

        return result;
    }
}