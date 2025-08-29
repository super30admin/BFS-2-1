# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english: This code calculates the total importance of an employee, including all their direct and indirect subordinates. It first builds a hashmap (self.map) to quickly access employees by their ID, then uses DFS starting from the given id to accumulate importance values. Each recursive call adds the current employee’s importance and then explores all subordinates until the full hierarchy is processed.

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        #TC: O(N) SC: O(N)
        self.result = 0
        self.map = {}

        for emp in employees:
            self.map[emp.id] = emp
        
        self.dfs(id)
        return self.result
    
    def dfs(self, id):
        curr = self.map[id]
        self.result += curr.importance
        subords = curr.subordinates

        for subord in subords:
            self.dfs(subord)