"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
# Time Complexity: O(N) where N are teh number of employees
# Space Complexity: O(N)
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:

        id_imp = {}
        id_mp = collections.defaultdict(list)

        for emp in employees: 
            id_imp[emp.id] = emp.importance
            id_mp[emp.id].extend(emp.subordinates)

        self.ans = 0

        def dfs(node): 
            if not node: 
                return 0
            self.ans += id_imp[node]
            for neigh in id_mp[node]: 
                dfs(neigh)
            
        dfs(id)
        return self.ans
                
