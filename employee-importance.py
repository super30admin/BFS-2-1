#----------------Solution 1 : BFS -----------
''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        result = 0
        hashmap = {}
        for emp in employees:
            hashmap[emp.id] = emp 
        
        q = deque()
        q.append(id)
        while q:
            curr = q.popleft()
            emp = hashmap[curr]
            result += emp.importance

            for subid in emp.subordinates:
                q.append(subid)
        
        return result

#----------------Solution 2 : DFS -----------
''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.result = 0
        self.hashmap = {}
        for emp in employees:
            self.hashmap[emp.id] = emp 
        
        self.dfs(id)
        return self.result

    def dfs(self, id):
        emp = self.hashmap[id]
        self.result += emp.importance

        for subid in emp.subordinates:
            self.dfs(subid)