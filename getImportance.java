// Time Complexity : O(V+E)
// Space Complexity : O(N)

/* Approach : We convert the list to hashmap of employee id and its employee details.
Now we add the given employee id into queue. Get the first employee id from queue and
add the its importance to a result variable and its subordinates to the queue. keep traversing
until queue is empty. In the end return result which is sum of given employee's importance and its
subordiante's importance.
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
        if(employees.size() == 0 || employees.isEmpty()) return 0;      // validate if employees is empty
        HashMap<Integer,Employee> eMap = new HashMap<>();               // initiailize a hashmap
        Queue<Integer> q = new LinkedList<>();                          // intitialize a queue
        q.add(id);                                                      // add given employee id into queue
        for(Employee e : employees){                                    // traverse over employee list
            eMap.put(e.id,e);                                           // add employee id and its employee object into map
        }
        
        int result = 0;                                                 // initialize a variable to store sum of importance for given employee and its subordinates

        while(!q.isEmpty()){                                            // validate if queue is empty
            int eId = q.poll();                                         // get first element out of queue
            result = result + eMap.get(eId).importance;                 // get current employee's importance and add it to result
            for(int sub : eMap.get(eId).subordinates){                  // traverse through current employee's subordinates
                q.add(sub);                                             // add them to queue
            }
        }
        return result;
    }
}