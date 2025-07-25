"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""


# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        employee_map = {}
        for i in employees:
            employee_map[i.id] = i
        count = 0
        queue = deque()
        queue.append(id)
        while queue:
            curr = queue.popleft()
            currObject = employee_map[curr]
            count += currObject.importance

            for j in currObject.subordinates:
                queue.append(j)

        return count
