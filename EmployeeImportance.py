# Time Complexity: O(N), N is the size of the employees array
# Space Complexity: O(N)
# Did this code successfully run on Leetcode: Yes

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
        result = 0
        employee_map = {}
        queue = deque()

        for index in range(len(employees)): # O(Employees)
            employee = employees[index]
            if employee.id == id:
                queue.append(employee)

            employee_map[employee.id] = employee
        

        while len(queue):
            popped = queue.popleft()

            result += popped.importance

            for employee in popped.subordinates:
                queue.append(employee_map[employee])
        
        return result

