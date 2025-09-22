/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

/*
* Use map to add employee id along with the importance and subordinates for constant search
* Using BFS traversal, iterate over each id and add its importance to result and subordinates to the queue
*/

//TC: O(n) -> iterate over all the employees in the list
// SC: O(n) -> map to store all employees and queue to store list of subordinates

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();

        //fill the map with employee id along with its importance and subordinates
        for(Employee e : employees){
            map.put(e.id, e);
        }

        //maintain a queue to add id and their subordinates
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int res = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            //add importance of each id in result
            res += map.get(curr).importance;

            //iterate over the list of subordinates and add it to the queue to get their importance
            for(int temp: map.get(curr).subordinates){
                q.add(temp);
            }
        }
        return res;
    }
}
