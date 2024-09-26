/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
Time Complexity = O(N)
Space Complexity = O(N)
where N is the number of elements in the vector employees.
*/
class Solution {
public:
    int sum=0;
    map <int, Employee*> m;
    int getImportance(vector<Employee*> employees, int id) {
        int i;
        for(i=0;i<employees.size();i++)
            m[employees[i]->id] = employees[i];
        dfs(employees,id);
        return sum;
    }
    void dfs(vector<Employee*> employees, int id)
    {
        //basic
        
        //logic
        Employee* E = m[id];
        sum+=E->importance;
        int l = E->subordinates.size();
        vector<int> sub(E->subordinates);
        if(l)
        {
            for(int i=0;i<l;i++)
                dfs(employees,sub[i]);
        }
    }
};


/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
Time Complexity = O(N)
Space Complexity = O(N)
where N is the number of elements in the vector employees.
*/
class Solution {
public:
    int sum=0;
    map <int, Employee*> m;
    int getImportance(vector<Employee*> employees, int id) {
        int i;
        for(i=0;i<employees.size();i++)
            m[employees[i]->id] = employees[i];
        queue <int> q;
        q.push(id);
        while(!q.empty())
        {
            Employee* E = m[q.front()];
            sum+=E->importance;
            vector<int> temp(E->subordinates);
            q.pop();
            int l = temp.size();
            for(i=0;i<l;i++)
                q.push(temp[i]);
        }
        return sum;
    }
};
