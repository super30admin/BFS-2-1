# Problem 2 : Employee Importance
# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
from collections import deque

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # hashmap for employee
        employee_map = { employee.id: employee for employee in employees}
        # queue for bfs
        queue = deque()
        # append the id in the queue
        queue.append(id)
        # variable to store result importance
        result = 0
        # loop until queue is not empty
        while queue:
            # pop the employee id from the queue
            eId = queue.popleft()
            # get the employee for the employee id
            emp = employee_map[eId]
            # add the importance of the employee to the result
            result += emp.importance
            # add all the subordinates of the employee to the queue
            for empSub in emp.subordinates:
                queue.append(empSub)
        return result
        