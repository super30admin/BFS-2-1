#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
class Employee{
public:
    int id;
    int importance;
    vector<int> subordinates;
};
/*
First map every employee ID to their object for easy access
Then do BFS starting from the given employeem adding their importance
Keep exploring subordinates until all the levels are visited and summed up
*/
class Solution{
public:
    unordered_map<int, Employee*> map;
    int getImportance(vector<Employee*> employees, int id) {
       for(auto emp : employees){
            map[emp->id] = emp;
       }

       queue<int> q;
       q.push(id);
       int result = 0;

       while(!q.empty()){
            int currId = q.front(); q.pop();
            Employee* currObj = map[currId];
            result += currObj->importance;

            for(int subId : currObj->subordinates){
                q.push(subId);
            }
        }
        return result; 
    }
};
