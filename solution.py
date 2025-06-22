# Problem 1

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        myq = deque()
        fresh = 0
        dirs = ((1,0),(-1,0),(0,1),(0,-1))
        m = len(grid)
        n = len(grid[0])

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh +=1
                elif grid[i][j] == 2:
                    myq.append((i,j))
        mins = 0
        if fresh == 0:
            return 0
        while myq:
            for i in range(len(myq)):
                pos = myq.popleft()

                for r,c in dirs:
                    newrow = pos[0] + r
                    newcol = pos[1] + c

                    if newrow >= 0 and newrow < m and newcol >=0 and newcol < n and grid[newrow][newcol]==1:
                        grid[newrow][newcol] = 2
                        myq.append((newrow,newcol))
                        fresh -=1
            mins +=1
        print(mins)
        return mins - 1 if fresh == 0 else -1

##  problem 2 (DFS solution )

from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:

        if not employees:
            return 0 
        mymap = {}

        for i in range(len(employees)):
            mymap[employees[i].id] = employees[i]
        self.imp = 0
        def dfs(root):
            self.imp += root.importance
            if root.subordinates == []:
                return 
            for idx in root.subordinates:
                mynode = mymap[idx]
                dfs(mynode)
        dfs(mymap[id])
        return self.imp


##problem 2 (BFS solution)



from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:

        if not employees:
            return 0 
        mymap = {}
        for i in range(len(employees)):
            mymap[employees[i].id] = employees[i]      
        imp = 0 
        myq = deque()
        myq.append(mymap[id])
        while myq:
            elem = myq.popleft()
            imp += elem.importance 
            for sub in elem.subordinates:
                myq.append(mymap[sub])
        return imp
        
                










        
    
        





