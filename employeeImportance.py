# Time: O(n) every node traversed
# Space: O(h) recursion stack
# Leetcode: Yes
# Issues: couldn't initialize result local
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        result = 0
        hmap = {emp.id:emp for emp in employees}            # id : pointer to all data

        def dfs(id1):
            nonlocal result                                 # parent variable access//[0]  
            currEmp = hmap[id1]                             # current id pointer
            result += currEmp.importance                    # add result

            for subIds in currEmp.subordinates:             # children 
                dfs(subIds)                                 #recursion for children//and their children

        dfs(id)
        return result