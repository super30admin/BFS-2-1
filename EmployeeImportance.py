
#DFS Approach 
# Time Complexity : O(N)
class Solution:
    def getImportance(self,employee : List['Employee'], id : int) -> int:
        if employee == None:
            return 0
        self.map = dict()
        self.total = 0
        for emp in employee:
            self.map[emp.id] = emp
        self.dfs(id)
        return self.total
    
    def dfs(self,id:int) ->None:
        emp = self.map[id]
        self.total = self.total + emp.importance
        for sub in emp.subordinates:
            self.dfs(sub)