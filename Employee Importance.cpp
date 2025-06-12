// Problem: Employee Importance
// Time complexity: O(N), where N is the number of employees.
// Space complexity: O(N), where N is the number of employees.
// Did this code pass all test cases? Yes, it passed all test cases.

// Approach: 
// 1. Create a map to store the employees by their ID for quick access.
// 2. Use a depth-first search (DFS) to traverse the employee hierarchy starting from the given employee ID.


#include <vector>
#include <unordered_map>
using namespace std;
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};

class Solution {
public:
    unordered_map<int, Employee*> map;
    int ans;
    int getImportance(vector<Employee*> employees, int id) {
        // Make a map of ID to employee
        for(auto emp : employees){
            map[emp -> id] = emp;
        }
        dfs(id);
        return ans;
    }
private: 
    void dfs(int id){
        Employee* emp = map[id];
        ans += emp -> importance;
        for(int subId : emp -> subordinates) {
            dfs(subId);
        }
    }
};