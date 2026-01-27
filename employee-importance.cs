/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public IList<int> subordinates;
}
*/

// Time Complexity: O(n)
// Space Complexity: O(n)

// Build a dictionary to quickly map employee id & Employee object.
// Use a queue (BFS) starting from the given id to traverse the employee and all their subordinates.
// Sum the importance of each visited employee and return the total.
class Solution
{
    public int GetImportance(IList<Employee> employees, int id)
    {
        Queue<int> q = new();
        q.Enqueue(id);
        int result = 0;
        Dictionary<int, Employee> dict = new();
        foreach (var emp in employees)
        {
            dict.Add(emp.id, emp);
        }
        while (q.Count != 0)
        {
            int cid = q.Dequeue();
            Employee abc = dict[cid];
            result += abc.importance;
            foreach (var ab in abc.subordinates)
            {
                q.Enqueue(ab);
            }

        }
        return result;
    }
}