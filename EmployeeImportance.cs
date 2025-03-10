/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public IList<int> subordinates;
}
*/
// time complexity - O(n) n = umber if employees
// space complexity - O(n) for dict and queue
class Solution
{
    public int GetImportance(IList<Employee> employees, int id)
    {
        Dictionary<int, Employee> dict = new Dictionary<int, Employee>();
        Queue<int> bfs = new Queue<int>();
        int res = 0;
        foreach (var e in employees)
        {
            dict.Add(e.id, e);
        }
        bfs.Enqueue(id);

        while (bfs.Count > 0)
        {

            int curr = bfs.Dequeue();
            res = res + dict[curr].importance;
            for (int i = 0; i < dict[curr].subordinates.Count; i++)
            {
                int sub = dict[curr].subordinates[i];
                bfs.Enqueue(sub);
            }
        }
        return res;
    }
}