/*
Time Complexity (TC):
O(n) – where n is the number of employees.
Each employee is processed exactly once.

Space Complexity (SC):
O(n)
unordered_map stores all employees → O(n)
queue holds up to all employees in the worst case → O(n)

Approach (in 3 steps):
Map each employee's ID to their object for constant-time lookup.
Use a queue (BFS) to process the given employee and their subordinates recursively.
For each visited employee, add their importance to the total and enqueue all direct subordinates.
*/

/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        int totalImp = 0;
        unordered_map<int, Employee*> mp;
        for(Employee* e : employees)
            mp[e->id] = e;
        queue<int> q;
        q.push(id);
        while(!q.empty()){
            int curr = q.front();
            q.pop();
            Employee* e = mp[curr];
            totalImp += e->importance;
            for(int x : e->subordinates)
                q.push(x);
        }
        return totalImp;
    }
};
