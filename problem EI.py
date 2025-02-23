# Employee Impotance(https://leetcode.com/problems/employee-importance/)

#TC: O(n)
#SC: O(n)


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
        hm = {}
        size = len(employees)

        for e in employees:
            hm[e.id] = e
        
        q = deque()
        q.append(id)
        result = 0

        while q:
            eid = q.popleft()
            e = hm[eid]
            result += e.importance
            subIDs = e.subordinates
            for subID in subIDs:
                q.append(subID)
            
        return result


# DFS


"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def __init__(self):
        self.result = 0
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hm = {}

        for e in employees:
            hm[e.id] = e
        
        return self.dfs(hm,id)

        
    def dfs(self, hm,id):
         
        e = hm[id]
        self.result = e.importance
        subIds = e.subordinates
        for sid in subIds:
            self.result += self.dfs(hm,sid)
        
        return self.result

        
    

        