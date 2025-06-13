from typing import Optional,List,Deque
import collections

# class Solution:
#     def orangesRotting(self, grid: List[List[int]]) -> int:
#         q,m,n ,fresh,time= collections.deque() ,len(grid) ,len(grid[0]),0 ,0
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j] == 1:
#                     fresh+=1
#                 if grid[i][j] == 2:
#                     q.append((i,j))
#         if fresh == 0: return 0
#         dir = [[-1,0],[1,0],[0,-1],[0,1]]
#         while q:
#             size = len(q)
#             for i in range(size):
#                 r,c = q.popleft()
#                 for dx,dy in dir:
#                     nr,nc = r + dx,c+dy
#                     if nr>=0 and nc>=0 and nr<m and nc<n:
#                         if grid[nr][nc] == 1:
#                             fresh-=1
#                             q.append((nr,nc))
#                             grid[nr][nc] = 2
#             time+=1
#         return -1 if fresh!=0 else time-1

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m,n = len(grid) ,len(grid[0])
        dir = [[1,0],[-1,0],[0,1],[0,-1]]
        def dfs(grid, r,c, time,dir):
            nonlocal m,n
            #base
            if r<0 or c<0 or r==m or c==n: return

            if grid[r][c]!= 1 and grid[r][c] < time : return
            #logic
            grid[r][c] = time
            for x,y in dir:
                nr = r+x
                nc = c+y
                dfs(grid, nr,nc,time+1,dir)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    dfs(grid,i,j,2,dir)
        maxVal = 0            
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 : return -1
                maxVal = max(grid[i][j],maxVal)
        return 0 if maxVal == 0 else maxVal - 2
        

    
                        
                        
                        
        
        
                        
                        
                        
        
        