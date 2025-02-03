// Author: Subhed Chavan
// Batch: December 24
// Problem Statement:
// Approach:
// TC: O(n)
// SC: O(n)

/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution
{
public:
    int getImportance(std::vector<Employee *> employees, int id)
    {
        // Base Case
        if (employees.empty())
        {
            return 0;
        }

        unordered_map<int, Employee *> map;
        int total;
        total = 0;
        queue<int> q;

        // Store employee to map for quick look up O(1)
        for (Employee *e : employees)
        {
            map[e->id] = e;
        }

        // BFS
        q.push(id);
        while (!q.empty())
        {
            int currentId = q.front();
            q.pop();

            Employee *emp = map[currentId];
            total += emp->importance;

            for (int sub : emp->subordinates)
            {
                q.push(sub);
            }
        }

        return total;
    }
};