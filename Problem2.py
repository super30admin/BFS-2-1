# LEETCODE PROBLEM : 690. EMPLOYEE IMPORTANCE
# TIME COMPLEXITY: O(N) where N is the number of employee
# SPACE COMPLEXITY: O(N) where N is the number of employees being added in the queue 


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
        emp_map={emp.id: emp for emp in employees}
        q=deque([id])
        result=0

        while q:
            current_id=q.popleft()
            current_object=emp_map[current_id]
            result+=current_object.importance

            for subordinate_id in current_object.subordinates:
                q.append(subordinate_id)
        return result