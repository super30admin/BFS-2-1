"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""


class Solution:
    def getImportance(self, employees: List["Employee"], id: int) -> int:
        # T: O(n), S: O(n)
        emp_map = {e.id: e for e in employees}

        # BFS setup
        queue = deque([id])
        total_importance = 0

        while queue:
            emp_id = queue.popleft()
            employee = emp_map[emp_id]
            total_importance += employee.importance
            queue.extend(employee.subordinates)  # Add subordinates to queue

        return total_importance
