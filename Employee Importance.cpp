// Employee Importance
// time: O(n)
// space: O(n)
// bfs

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
        int result = 0;
        unordered_map<int,Employee*> umap;
        for(int i = 0; i < employees.size(); i++) {
            umap[employees[i]->id] = employees[i];
        }
        queue<int> ids;
        ids.push(id);
        while(!ids.empty()) {
            int sz = ids.size();
            
            for(int i = 0; i < sz; i++) {
                int curr = ids.front();
                ids.pop();
                Employee* currEmp = umap[curr];
                result += currEmp->importance;
                for(int j = 0; j < currEmp->subordinates.size(); j++) {
                    ids.push(currEmp->subordinates[j]);
                }
            }
        }
        return result;
    }
};