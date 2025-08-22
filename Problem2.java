
//Time complexity: O(n), where n is the number of employees. We process each employee once.
//Space complexity: O(n), where n is the number of employees. We use a queue to perform BFS and a map to store employee information.

//We use BFS traversal and start by adding the employee whose ID is given in the queue
// and explore all subordinates at each level and add their importance to the result.Finally return the result.
//We also use a map to store employee information for quick access.


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    //BFS
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        q.add(id);
        int res=0;
        while(!q.isEmpty()){
            int currId=q.remove();
            Employee currObj=map.get(currId);
            res+=currObj.importance;
            for(int subId:currObj.subordinates)
                q.add(subId);
        }
        return res;
    }
}