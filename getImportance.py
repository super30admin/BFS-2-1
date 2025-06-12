# // Time Complexity :O(V+E)
# // Space Complexity :O(V)/ employees
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

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
        #each and every employee can be considered as 
        # node and relation as vertex
        #wen can also consider id as root 
        #does level matter ? no 
        #  bfs
        imp=0
        # [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
        # empID,imporatnce ,subord
        d=dict()
        for emp in employees:
            d[emp.id]=emp
        q=deque()
        q.append(d[id])

        while(len(q)):
            emp=q.popleft()
            imp+=emp.importance
            
            for subs in emp.subordinates:
                
                q.append(d[subs])
        return imp



#####################################################################################################################################
        
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
        #with dfs when len of sub is zero then return 0
        d=dict()
        self.ans=0
        for emp in employees:
            d[emp.id]=emp
        def helper(emp):
          
            self.ans+=emp.importance
            for emp in emp.subordinates:
                helper(d[emp])
        helper(d[id])
        return self.ans

