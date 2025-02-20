# # DFS Approach usimg recusive stack
# TC - O(n)
# SC - O(h)

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
        self.total = 0
        self.adjList = defaultdict(List)

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees is None or len(employees) == 0 or id is None: return 0

        # map elements in adjList
        for emp in employees:
            self.adjList[emp.id] = emp
            # print(emp)

        print(self.adjList)

        # call dfs function
        self.dfs(id)

        return self.total

    def dfs(self, id):
        self.total += self.adjList[id].importance

        for subordinate in self.adjList[id].subordinates:
            self.dfs(subordinate)

