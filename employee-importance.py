'''
You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.

You are given an array of employees employees where:

employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.
'''
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        q = deque()
        total_importance = 0

        emp_map = {emp.id: emp for emp in employees}  # O(n) preprocessing


        # def helper(id):
        #     for emp in employees:
        #         if emp.id == id:
        #             return emp
        
        # q.append(helper(id))
        q.append(emp_map[id])

        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                # add subs to queue, update imp
                for sub in curr.subordinates:
                    # q.append(helper(sub))
                    q.append(emp_map[sub])
                total_importance += curr.importance
        return total_importance