# Time Complexity : O(n), where n is the number of employees
# Space Complexity : O(n), for the hashmap and recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used Depth-First Search (DFS) to recursively sum up the importance value of the given employee and all subordinates.
# First, I created a hashmap to map each employee's ID to the actual Employee object for quick lookup.
# Then I wrote a recursive helper that accumulates the importance value of the current employee and calls itself on all subordinates.

from typing import List

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # I created a hashmap for O(1) access to employees by ID
        emp_map = {e.id: e for e in employees}

        def dfs(eid):
            emp = emp_map[eid]
            total = emp.importance
            for sub_id in emp.subordinates:
                total += dfs(sub_id)
            return total

        return dfs(id)
