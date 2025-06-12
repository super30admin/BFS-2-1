# TC: O(m*n)
# SC: O(m*n) 

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q=deque([])
        m=len(grid)
        n=len(grid[0])

        dirs=[(0,1), (1,0), (0,-1), (-1,0)]
        fresh=0

        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    q.append((i,j))
                if grid[i][j]==1:
                    fresh+=1
        
        if fresh==0:
            return 0
        lvl=0
        while q:
            size=len(q)
            for s in range(size):
                nr, nc= q.popleft()
                for d in dirs:
                    if (nr+d[0] >=0 and nr+d[0] <= m-1) and (nc+d[1] >=0 and nc+d[1] <= n-1) and grid[nr+d[0]][nc+d[1]] == 1:
                        fresh-=1
                        grid[nr+d[0]][nc+d[1]]=2
                        q.append((nr+d[0], nc+d[1]))
            lvl+=1
                    
        
        if fresh!=0:
            return -1
        return lvl-1
        
        
                
