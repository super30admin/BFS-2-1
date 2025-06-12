"""
Time- O(n)
Space - O(n)

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        emp_map = {emp.id: emp for emp in employees}
        
        total_importance = 0
        q = deque([id])  
        
        while q:
            current_id = q.popleft()
            employee = emp_map[current_id]
            total_importance += employee.importance
            
            for sub_id in employee.subordinates:
                q.append(sub_id)
        
        return total_importance