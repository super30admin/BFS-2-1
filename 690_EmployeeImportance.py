
#Definition for Employee.
# Time Complexity: O(n)
# Space Complexity: O(n)

class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


from collections import deque
from typing import List


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if len(employees) == 0:
            return 0
        object_map = {}
        queue = deque()
        total = 0
        for employee in employees:
            object_map[employee.id] = employee
        queue.append(id)
        while queue:
            curr = queue.popleft()
            emp = object_map[curr]
            total = total + emp.importance
            for sub in emp.subordinates:
                queue.append(sub)
        return total