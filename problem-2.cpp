// https://leetcode.com/problems/employee-importance/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Insert all the employee objects along with their id in a hashmap.
// Start by putting the given id in a queue, perform BFS by inserting all the subordinates of each employee.
// Take the sum of importance of each employee while popping them out.

class Solution {
    public:
        int getImportance(vector<Employee*> employees, int id) {
            unordered_map<int,Employee*> mp;
            for(auto e:employees){
                mp[e->id] = e;
            }
            queue<int> q;
            q.push(id);
            int res=0;
            while(!q.empty()){
                auto a = q.front();
                q.pop();
                Employee* emp = mp[a];
                res += emp->importance;
                for(auto x:emp->subordinates) q.push(x);
            }
            return res;
        }
    };