"""
TC: O(N), Number of employees
SP: O(N) top store the references in hmap
"""

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
        q = deque()
        for e in employees:
            hmap[e.id]=e
            if e.id==id:
                q.append(e)
        total = 0
        while q:
            for _ in range(len(q)):
                emp = q.popleft()
                total+=emp.importance
                for s in emp.subordinates:
                    q.append(hmap[s])
        return total