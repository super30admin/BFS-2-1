// ## Problem 2

// Employee Impotance(https://leetcode.com/problems/employee-importance/)

// You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.

// You are given an array of employees employees where:

// employees[i].id is the ID of the ith employee.
// employees[i].importance is the importance value of the ith employee.
// employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
// Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.

Approach: If we form a tree we can do a BFS traversal. To get the subordinates we need to go linearly but what we can do isBalanced
We can maintain ahashmap so that we can get it in constant time and then traverse it.
We will maintain an total variable which will give the sub of importance.

Time Complexity : O(n) where n is the no of nodes on that tree of which we are given a id
Space Complexity : O(N) N-> is for hashmap even though we are given a leaf node still we are inserting all objects into a hashmap 


class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size()==0){
            return 0;
        }
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        //Hashmap
        for(Employee e:employees){
            map.put(e.id,e);
        }

        q.add(id);
        int total=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            Employee obj=map.get(curr);
            total=total+obj.importance;
            for(int i:obj.subordinates){
                q.add(i);
            }
        }
        return total;
    }
}