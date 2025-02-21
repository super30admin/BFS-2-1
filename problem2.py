# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
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
        map = {}
        for emp in employees:
            map[emp.id] = emp

        def dfs(id):
            if id not in map:
                return

            val = map[id].importance
            for sub in map[id].subordinates:
                val += dfs(map[sub].id)
            return val
        
        return dfs(id)

        