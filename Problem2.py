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
        hmap = {}
        result = 0
        for item in employees:
            id_ = item.id
            hmap[id_] = item
        
        q = deque()
        q.append(id)
        while q:
            curr = q.popleft()
            emp = hmap[curr]
            result += emp.importance
            li = emp.subordinates
            for i in li:
                q.append(i)
        
        return result


        