# 690. Employee Importance

# Time Complexity: O(n)
# Space Complexity: O(n)

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        map = dict()

        for i in employees:
            map[i.id] = i
        
        q = deque()
        q.appendleft(id)
        result = 0

        while q:
            curr = q.pop()
            result += map[curr].importance
            for sub in map[curr].subordinates:
                q.appendleft(sub)
        
        return result
