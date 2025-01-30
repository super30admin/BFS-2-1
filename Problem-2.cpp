/*
TC : O(N)
SC : O(N)
*/
/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution
{
public:
    int getImportance(vector<Employee *> employees, int id)
    {
        if (employees.size() == 0 || employees.empty())
        {
            return 0;
        }

        map<int, Employee *> hashMap;
        int total = 0;
        queue<int> store;

        // to quickly fetch the employee details
        for (auto i : employees)
        {
            hashMap[i->id] = i;
        }

        // add the importance of all the nested subordinates
        store.push(id);
        while (!store.empty())
        {
            Employee *curr = hashMap[store.front()];
            total += curr->importance;
            for (int i = 0; i < curr->subordinates.size(); i++)
            {
                store.push(curr->subordinates[i]);
            }
            store.pop();
        }

        return total;
    }
};