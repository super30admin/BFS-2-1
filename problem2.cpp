// Time Complexity : O(n), n = number of employees
// Space Complexity : O(n), n = number of employees
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Build a hashmap of id:empObject for efficient lookups
// Start DFS from the given id and sum up the importance of all its children and subchildren
// Return the final importance value

class Solution {
private:
    void dfs(int id, unordered_map<int, Employee*>& adjList, int& importance) {
        // get current employee and update importance
        Employee* currEmp = adjList[id];
        importance += currEmp->importance;

        // call dfs again on its children
        for(auto& child : currEmp -> subordinates) {
            dfs(child, adjList, importance);
        }
    }
public:
    int getImportance(vector<Employee*> employees, int id) {
        // build adj list: key = empId, value = emp object
        unordered_map<int, Employee*> adjList;
        for(auto& emp : employees) {
            adjList[emp->id] = emp;
        }
        int importance = 0;
        dfs(id, adjList, importance);

        return importance;
    }
};