"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
# Space Complexity - o(n)
# Time Complexity - o(n)

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        hashTb = {}

        for e in employees:
            hashTb[e.id] = e

        importance = hashTb[id].importance

        def dfs(hashTb,e,imp):
            
            for s in e.subordinates:
                imp+= dfs(hashTb,hashTb[s],hashTb[s].importance)

            return imp

        

        return dfs(hashTb,hashTb[id], importance)