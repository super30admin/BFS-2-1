# Time Complexity = O(n)
# Space Complexity = O(n)
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
        empMap = {e.id: e for e in employees}  
        totalImportance = 0
        q = deque([id])  # Queue for BFS

        while q:
            emp_id = q.popleft()
            employee = empMap[emp_id]  
            totalImportance += employee.importance  
            q.extend(employee.subordinates) 
        return totalImportance