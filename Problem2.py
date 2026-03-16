#Employee Importance

# Timr -> On
# Space -> On

# Definition for Employee.
from typing import List
from collections import deque

class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        #find the employee node 1st whose total we want to return.
        # then calculate the sum of all importances of all it's child nodes

        employeeSubordinateMap = {}
        employeeImportanceMap = {}

        for employee in employees:
            employeeSubordinateMap[employee.id] = employee.subordinates
            employeeImportanceMap[employee.id] = employee

        
        empoylyesToConsider = deque()
        empoylyesToConsider.append(id)
        importance = 0
        while empoylyesToConsider:
            empId = empoylyesToConsider.popleft()
            emp = employeeImportanceMap[empId]
            importance += emp.importance
            for subIds in emp.subordinates:
                empoylyesToConsider.append(subIds)

        
        return importance