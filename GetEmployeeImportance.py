from typing import List
from collections import deque
import collections

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


# class Solution:
#     def getImportance(self, employees: List['Employee'], id: int) -> int:
#         hashMap = {}
#         res = 0
#         for e in employees:
#             hashMap[e.id] = e
#         def dfs(hm,emp, id):
#             #base
            
#             #logic
#             e = hm.get(id)
#             res = e.importance
#             for s in e.subordinates:
#                 id = hm.get(s).id
#                 res+=dfs(hm,emp,id)
#             return res

#         return dfs(hashMap,employees,id) 

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashMap = {}
        res = 0
        for e in employees:
            hashMap[e.id] = e
        q = collections.deque()
        q.append(id)
        while q :
            curr = q.popleft()
            e=hashMap.get(curr)
            res+=e.importance
            for s in  e.subordinates:
                q.append(s)
        return res
        