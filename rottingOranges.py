from collections import deque
class Solution:
    def orangesRotting(self,grid):
        rows,cols=len(grid),len(grid[0])
        queue=deque()
        fresh=0

        for r in range(rows):
            for c in range(cols):
                if grid[r][c]==2:
                    queue.append((r,c))
                elif grid[r][c]==1:
                    fresh +=1

        if fresh==0:
            return 0
        
        directions=[(-1,0),(1,0),(0,-1),(0,1)]
        minutes=0

        while queue and fresh>0:
            minutes +=1
            for _ in range(len(queue)):
                r,c=queue.popleft()
                for dr,dc in directions:
                    nr,nc=r+dr,c+dc
                    if 0<=nr<rows and 0<=nc<cols and grid[nr][nc]==1:
                        grid[nr][nc]=2
                        queue.append((nr,nc))
                        fresh -=1
        return minutes if fresh ==0 else -1
    

sol=Solution()
print(sol.orangesRotting(grid =[[2,1,1],[1,1,0],[0,1,1]]))
print(sol.orangesRotting(grid =[[2,1,1],[0,1,1],[1,0,1]]))
print(sol.orangesRotting(grid = [[0,2]]))