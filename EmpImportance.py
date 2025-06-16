# Time Complexity: O(V+E)
# Space Complexity: O(V+E)

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
        result = 0 
        hmap = dict()
        for e in employees:
            hmap[e.id] = e
        q = deque()
        q.append(id)
        while q:
            eid = q.popleft()
            e = hmap[eid]
            result += e.importance
            # process the children
            for subId in e.subordinates:
                q.append(subId)
        return result
