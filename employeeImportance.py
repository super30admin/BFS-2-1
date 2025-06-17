"""
Approach: Create a Data structure through which we can look up nodes easily. therefore build the graph using the 
hashmap. then run a DFS to get all the children + parent importance of given node.
t.c. => O(n) where n is the number of nodes
s.c. => O(h) height of that tree
"""
from collections import deque
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
        idToindex = defaultdict(int)
        for i in range(len(employees)):
            idToindex[employees[i].id] = i

        q = deque()
        res = 0
        q.append(id)

        while q:
            node = q.popleft()
            employee = employees[idToindex[node]]
            res += employee.importance

            for child in employee.subordinates:
                q.append(child)
        return res