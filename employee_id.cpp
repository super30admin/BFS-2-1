//Time O(n)
//Space O(n)
//Leetcode: yes
//Issue seen : none
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
    int imp=0;
    unordered_map<int,Employee*> mp;
public:
    int getImportance(vector<Employee*> employees, int id) {
        for(int i=0; i< employees.size(); i++){
            mp[employees[i]->id] = employees[i]; 
        }
        dfs(id);
        return imp;
    }
    void dfs(int id){
        Employee *e = mp[id];
        imp = imp + e->importance;
        for(int i=0; i<e->subordinates.size(); i++){
            dfs(e->subordinates[i]);
        }
    }
};
