"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    # dfs approach
    # TC : O(n) -- no of sub ordinates for given id
    # SC : O(N) => O(n+h) -- no of sub ordinates for given id +height of tree
    def dfs(self,id:int):
        # base

        # logic
        emp = self.hmap[id]
        self.totalimportance += emp.importance
        for sub in emp.subordinates:
            self.dfs(sub)

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        if len(employees) == 0:
            return 0
        self.hmap = {}
        self.totalimportance = 0
        for employee in employees:
            self.hmap[employee.id] = employee
        self.dfs(id)

        return self.totalimportance