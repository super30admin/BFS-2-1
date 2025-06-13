# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        # Build a map from id to Employee object
        emp_map = {emp.id: emp for emp in employees}
        total_importance = 0
        queue = [id]
        while queue:
            curr_id = queue.pop(0)
            employee = emp_map[curr_id]
            total_importance += employee.importance
            queue.extend(employee.subordinates)
        return total_importance
        