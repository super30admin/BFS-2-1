# 690. Employee Importance
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
        Map = {}
        result = 0

        for emp in employees:
            Map[emp.id] = emp

        q = deque()
        q.append(id)

        while q:
            curr_id = q.popleft()
            emp_obj = Map[curr_id]
            emp_imp = emp_obj.importance
            result += emp_imp

            for sub in emp_obj.subordinates:
                q.append(sub)

        return result

        