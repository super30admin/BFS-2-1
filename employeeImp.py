from typing import List
from collections import deque

class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class BFSSolution:
# Time Complexity : O(N) 
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

    # BFS
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        q = deque()
        hashmap = {}
        importance = 0
        
        for employee in employees:
            hashmap[employee.id] = employee
        
        q.append(id)
        
        while len(q):
            employee = hashmap.get(q.popleft())
            importance += employee.importance
            for subordinate in employee.subordinates:
                q.append(subordinate)
        
        return importance
    
class DFSSolution:
# Time Complexity : O(N) 
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

    # DFS
    def __init__(self):
        self.importance = 0
        self.hashmap = {}

    def getImportance(self, employees: List["Employee"], id: int) -> int:
        for employee in employees:
            self.hashmap[employee.id] = employee

        self.dfs(self.hashmap.get(id))

        return self.importance

    def dfs(self, employee: Employee) -> None:
        self.importance += employee.importance
        for subordinate in employee.subordinates:
            self.dfs(self.hashmap.get(subordinate))