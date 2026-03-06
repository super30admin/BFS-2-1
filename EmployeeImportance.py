# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Map every employee ID to their object for easy access.
# Do BFS starting from the given employee, adding their importance.
# Keep exploring subordinates until all levels are visited and summed up.

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
        id_emp_map = {}

        for employee in employees:
            id_emp_map[employee.id] = employee

        q = deque()
        q.append(id)
        res = 0

        while q:
            currId = q.popleft() 
            currEmp = id_emp_map[currId]
            res += currEmp.importance

            for subId in currEmp.subordinates:
                q.append(subId)

        return res       

        