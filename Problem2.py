"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
# Time Complexity --> O(n)
# Space Complexity --> O(n)
# Approach --> DFS
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hmap = {}
        for emp in employees:
            hmap[emp.id] = emp
        self.result = 0
        self.dfs(id, hmap)
        return self.result
    
    def dfs(self, id, hmap):
        self.result += hmap[id].importance
        for subordinate in hmap[id].subordinates:
            self.dfs(subordinate, hmap)


'''
# Time Complexity --> O(n)
# Space Complexity --> O(n)
# Approach --> BFS
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hmap = {}
        for e in employees:
            hmap[e.id] = e
        q = deque()
        q.append(id)
        result = 0
        while len(q)>0:
            currid = q.popleft()
            curremp = hmap[currid]
            result += curremp.importance
            for subordinate in curremp.subordinates:
                q.append(subordinate)
        return result 
'''
