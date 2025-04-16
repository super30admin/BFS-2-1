// Time Complexity : O(N) N is #of employees
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Traverse each employee and its sub ordinates using BFS, adding their importance to final sum.
// 2. To traverse employee push it to queue using its id also use hashmap to map id's with emplyee object. 
// 3. If current employee has id's of subordinates push that employee to queue using their id in hashmap .

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
        queue<Employee*> q;
        int sum=0;
        map<int,Employee*> m;
        for(int i=0;i<employees.size();i++){
            if( (employees[i])->id == id ){
                q.push(employees[i]);
                //sum=employees[i]->importance;
                m[id]=employees[i];
            }
            m[(employees[i])->id]=employees[i];
        }
        
        while(!q.empty()){
            Employee* emp=q.front();
            sum=sum+(emp->importance);
            vector<int> v =(emp->subordinates);
            int n=v.size();
            for(int i=0;i<n;i++){
                q.push(m[v[i]]);
            }
            q.pop();
        }
        return sum;
    }
};