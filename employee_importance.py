'''
690 Employee Importance
https://leetcode.com/problems/employee-importance/description/

You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.

You are given an array of employees employees where:
    employees[i].id is the ID of the ith employee.
    employees[i].importance is the importance value of the ith employee.
    employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.

Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.

Example 1:
Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
Output: 11
Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
They both have an importance value of 3.
Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.

Example 2:
Input: employees = [[1,2,[5]],[5,-3,[]]], id = 5
Output: -3
Explanation: Employee 5 has an importance value of -3 and has no direct subordinates.
Thus, the total importance value of employee 5 is -3.

Constraints:
1 <= employees.length <= 2000
1 <= employees[i].id <= 2000
All employees[i].id are unique.
-100 <= employees[i].importance <= 100
One employee has at most one direct leader and may have several subordinates.
The IDs in employees[i].subordinates are valid IDs.

Solution:
1. BFS
Perform standard breadth-first traversal where the root node is the input parameter employee id. This is the first element added to the queue. Set total_importance = 0
While queue is not empty:
a) pop the front element from the queue (left most element) to get the current id
b) Using a hash map <id, <importance, subordinates>>, get the importance value of the current id and add it to the total importance
c) For every subordinate present in the subordinates list, append it to the queue. Go to Step a
Time: O(N), Space: O(N)
https://youtu.be/j7F9aPgF5y8?t=4181

2. DFS
Time: O(N), Space: O(N)
https://youtu.be/j7F9aPgF5y8?t=4727
'''
from typing import List
from collections import deque, defaultdict

class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

def make_list_of_objects(employees):
    if not employees:
        return None
    E = []
    for e in employees:
        id, imp, subs = e[0], e[1], e[2]
        obj = Employee(id, imp, subs)
        E.append(obj)
    return E

def employee_importance_bfs(employees, id):
    '''
    BFS
    'employees' is a List of Employee objects
    '''
    if not employees:
        return -1

    h = defaultdict(list)
    for e in employees:
        h[e.id] = [e.importance, e.subordinates]

    q = deque()
    q.append(h[id])
    total_importance = 0
    while q:
        curr_imp, curr_subs = q.popleft()
        total_importance += curr_imp
        for nbr_id in curr_subs:
            q.append(h[nbr_id])
    return total_importance

def employee_importance_dfs(employees, id):
    '''
    DFS
    'employees' is a List of Employee objects
    '''
    def dfs(id):
        nonlocal total_importance
        curr_imp, curr_subs = h[id][0], h[id][1]
        total_importance += curr_imp
        for nbr_id in curr_subs:
            dfs(nbr_id)


    if not employees:
        return -1

    h = defaultdict(list)
    for e in employees:
        h[e.id] = [e.importance, e.subordinates]

    total_importance = 0
    dfs(id)
    return total_importance

def run_tests():
    tests = [([[1,5,[2,3]],[2,3,[]],[3,3,[]]], 1, 11),
             ([[1,5,[2,3]],[2,3,[]],[3,3,[]]], 2, 3),
             ([[1,2,[5]],[5,-3,[]]], 5, -3),
    ]
    for test in tests:
        employees, id, ans = test[0], test[1], test[2]
        emp_objects = make_list_of_objects(employees)
        print(f"\nEmployees = {employees}")
        for method in ['bfs', 'dfs']:
            if method == 'bfs':
                importance = employee_importance_bfs(emp_objects, id)
            elif method == 'dfs':
                importance = employee_importance_dfs(emp_objects, id)
            print(f"Target employee id = {id}")
            print(f"{method}: Target employee importance = {importance}")
            passed = (ans == importance)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}\n")
    print(f"\nDONE")

run_tests()