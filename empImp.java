/*
 * TC: O(n) n" total employees
 * SC: O(n) all the empl stored in hmap and queue.
 * 
 * Appraoch: Initially, i will create a hasmap to store the employee id with its index. Then BFS on all its children and keep calculating
 * the imp until the Queue is empty. At the end, return imp.
 */


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        Queue<Employee> q = new LinkedList<>();
        int imp = 0,index = 0;

        for(Employee e : employees)
            hmap.put(e.id, index++);

        q.add(employees.get(hmap.get(id)));
        while(!q.isEmpty()){
            Employee curr = q.poll();

            imp += curr.importance;

            for(int subid : curr.subordinates)
                q.add(employees.get(hmap.get(subid)));
        }
    return imp;  
    }
}