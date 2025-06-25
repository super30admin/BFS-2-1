//Time Complexity : O(n)
//Space Complexity : O(n)
#include<iostream>
#include<vector>
#include<unordered_map>
#include<queue>
using namespace std;
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};


class Solution {
public:
    unordered_map<int,Employee*>hm;
    int getImportance(vector<Employee*> employees, int id) {
        queue<int>q;
        for(auto& x : employees){
            hm[x->id]=x;
        }
        q.push(id);
        int ans=0;
        while(!q.empty()){
            int temp = q.front();
            Employee* curr = hm[temp];
            ans += curr->importance;
            q.pop();
            for(auto& x : curr->subordinates){
                q.push(x);
            }
        }
        return ans;
    }
};