"""
time - o(n)
space - o(n)
we take the employee list and create a dictionary of employee id and employee object as value
we then take the employee id whose score we need, add it to a queue and then perform bfs to find total score
"""
from typing import List
from collections import deque
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        emp_map = {}
        for emp in employees:
            emp_map[emp.id] = emp
        
        q = deque()
        q.append(id)
        score = 0
        while q:
            emp = emp_map[q.popleft()]
            score += emp.importance
            q.extend(emp.subordinates)
        
        return score
        