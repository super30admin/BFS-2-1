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
        var dict = new Dictionary<int,Employee>();
        foreach(var emp in employees)
        {
            dict.Add(emp.id,emp);
        }
        Queue<int> q = new Queue<int>();
        q.Enqueue(id);
        int result=0;
        while(q.Count>0)
        {
            int qItem = q.Dequeue();
            Employee employee = dict[qItem];
            result = result + employee.importance;
            foreach(var sub in employee.subordinates)
            {
                q.Enqueue(sub);
            }
        }
        return result;
    }
}