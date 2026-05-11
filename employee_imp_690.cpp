/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/
//TC: O(m*n)
//SC: O(1)
class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        queue<int> q;
        unordered_map<int, Employee*> map;
        int total=0;
        for(auto emp:employees)
        {
            map[emp->id]=emp;
        }
        q.push(id);
        if(employees.size()==0)
            return 0;
        while(!q.empty())
        {
            auto id=q.front(); q.pop();
            Employee* emp=map[id];
            total+=emp->importance;
            if(emp->subordinates.empty())
                continue;
            else
            {
                for(auto e:emp->subordinates)
                    q.push(e);
            }
        }
        return total;
    }
};
