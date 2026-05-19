// Time Complexity : O(n) where n is the total number of employees
// Space Complexity : O(n) = space occupied by hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I use a dictionary to store the mapping between each employee id and the corresponding employee object. I perform BFS starting at 
the employee with id = id. I remove the id from the queue and add the corresponding importance to the final result. I then loop
through all the subordinates of that employee and add them to the queue and repeat the process till the queue is empty.
*/

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public IList<int> subordinates;
}
*/

class Solution {
    public int GetImportance(IList<Employee> employees, int id) {
        Dictionary<int, Employee> employeeLookup = new();
        
        foreach(Employee e in employees)
        {
            employeeLookup[e.id] = e;
        }

        int totalImportance = 0;

        Queue<int> q = new();
        q.Enqueue(id);

        while(q.Count!=0)
        {
            int currentId = q.Dequeue();
            Employee temp = employeeLookup[currentId];
            totalImportance += temp.importance;

            foreach(int subordinateId in temp.subordinates)
            {
                q.Enqueue(subordinateId);
            }
        }

        return totalImportance;
    }
}