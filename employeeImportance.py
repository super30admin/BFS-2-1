"""
Build a map that maps employee ID to employee object
Use queue to explore employees level by level
At each step, add the importance and enqueue subordinates
"""
""" 
Time Complexity: O(N) — All employees visited once
Space Complexity: O(N) — For the map and queue
"""

from typing import List
from collections import deque

class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class employeeImportance:
    def getImportance(self, employees: List[Employee], id: int) -> int:
        emp_map = {e.id: e for e in employees}
        total = 0
        queue = deque([id])

        while queue:
            current_id = queue.popleft()
            emp = emp_map[current_id]
            total += emp.importance
            for sub_id in emp.subordinates:
                queue.append(sub_id)

        return total

if __name__ == "__main__":
    e1 = Employee(1, 5, [2, 3])
    e2 = Employee(2, 3, [])
    e3 = Employee(3, 3, [])
    employees = [e1, e2, e3]

    obj = employeeImportance()
    print(obj.getImportance(employees, 1))
