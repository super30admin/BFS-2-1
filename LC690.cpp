// Time complexity O(n)
// Space complexity O(n)
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
        unordered_map<int, Employee*> employee_map;
        for (const auto& employee : employees) {
            employee_map[employee->id] = employee;
        }

        int importance = 0;

        queue<int> que;
        que.push(id);
        while (!que.empty()) {
            int employee_id = que.front();
            que.pop();

            auto it = employee_map.find(employee_id);
            if (it != employee_map.end()) {
                Employee* e = it->second;
                importance += e->importance;

                for (const auto& subordinate : e->subordinates) {
                    que.push(subordinate);
                }

            } 
        }

        return importance;
    }
};