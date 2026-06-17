# Time Complexity --> O(m*n) will be the amortized complexity. As the number of initial rotten oranges increases, the number of times revisiting an orange will decrease since the distance increases. 
# Space Complexity --> O(m*n)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        self.dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    self.dfs(grid, i, j, 2) 
        
        maxi = 2
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    return -1
                maxi = max(maxi, grid[i][j])
        return maxi-2
        
    
    def dfs(self, grid, r, c, time):
        #base 
        if r<0 or c<0 or r==len(grid) or c==len(grid[0]):
            return
        if grid[r][c]!=1 and grid[r][c]<time:
            return

        #logic
        grid[r][c] = time 
        for dir in self.dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            self.dfs(grid, nr, nc, time+1)





'''
# Time Complexity --> O(m*n)
# Space Complexity --> O(m*n)

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque()
        m = len(grid)
        n = len(grid[0])
        fresh = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    q.append((i,j))
                elif grid[i][j]==1:
                    fresh += 1
        
        if len(q)==0 and fresh==0:
            return 0

        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        time = 0
        while len(q)>0:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for dir in dirs:
                    nr = curr[0] + dir[0]
                    nc = curr[1] + dir[1]
                    if nr>=0 and nr<m and nc>=0 and nc<n and grid[nr][nc]==1:
                        q.append((nr,nc))
                        grid[nr][nc] = 2
                        fresh -= 1
            time += 1
        
        if fresh>0:
            return -1
        return time-1

'''
