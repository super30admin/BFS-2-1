// Problem : Employee importance
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this :  No

// Your code here along with comments explaining your approach in three
// sentences only
// 1. Prepare an  unordered_map of employee id and Employee object
// 2. Do a DFS traversal from the id
// 3. Keep adding the importance, and return the importance in the end

#include <bits/stdc++.h>
using namespace std;

class Employee {
public:
  int id;
  int importance;
  vector<int> subordinates;
};

class Solution {
public:
  unordered_map<int, Employee *> u;
  int getImportance(vector<Employee *> employees, int id) {
    for (Employee *it : employees) {
      u[it->id] = it;
    }
    return dfs(id);
  }

  int dfs(int id) {
    int importance = u[id]->importance;
    for (int it : u[id]->subordinates) {
      importance += dfs(it);
    }
    return importance;
  }
};
