/*
  Time complexity: O(N)
  Space complexity: O(N)

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
    public int GetImportance(IList<Employee> employees, int id) 
        {
            var total = 0;
            var employeeDict = employees.ToDictionary(e => e.id);
            if (!employeeDict.TryGetValue(id, out var employee))
                return 0;
            int currentId;
            Employee item;
            var allRelated = new Queue<int>();
            allRelated.Enqueue(employee.id);
            while (allRelated.Count > 0)
            {
                currentId = allRelated.Dequeue();
                item = employeeDict[currentId];
                total += item.importance;
                if (item.subordinates.Count == 0)
                    continue;
                foreach (var subId in item.subordinates)
                {
                    allRelated.Enqueue(subId);
                }

            }
        return total;
        }   
}
