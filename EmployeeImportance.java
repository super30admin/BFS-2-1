/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: Maintain a hashmap to associate an id with the employee object and do BFS to get the overall importance
class Solution {
    public int getImportance(List<Employee> employees, int id) {

        int importance = 0;
        HashMap<Integer,Employee> map = new HashMap<>();

        // Iterate throught the list and map employee ID to the corresponding employee
        for(int i=0; i < employees.size(); i++)
        {
            Employee employee = employees.get(i);
            map.put(employee.id, employee);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        //Do a BFS and keep incrementing the importance
        while(!q.isEmpty())
        {
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                Employee employee = map.get(q.poll());
                importance += employee.importance;
                q.addAll(employee.subordinates);
            }
        }
        return importance;
    }
}