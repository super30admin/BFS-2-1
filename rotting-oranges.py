# Time O(m*n)
# Space O(m*n)
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        directions = [(-1,0), (1,0), (0,-1), (0,1)]
        dq = deque()
        time = 0
        countF = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    dq.append((i, j))
                if grid[i][j] == 1:
                    countF += 1
        if countF == 0 : return 0
        while(len(dq) > 0):
            size = len(dq)
            time += 1
            for i in range(size):
                r, c = dq.popleft()
                for u, v in directions:
                    nr = r + u
                    nc = c + v
                    if -1 < nr < m and -1 < nc < n and grid[nr][nc] == 1:
                        countF -= 1
                        grid[nr][nc] = 2
                        dq.append((nr, nc))
        return -1 if countF > 0 else time-1
        

# Time O(2m*n)
# Space O(m*n)
from collections import deque
class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
        self.mat = None

    def orangesRotting(self, grid: List[List[int]]) -> int:
        self.m = len(grid)
        self.n = len(grid[0])
        self.mat = grid
        for i in range(self.m):
            for j in range(self.n):
                if self.mat[i][j] == 2:
                    self.dfs(i, j, 2)
        max_time = 0
        for i in range(self.m):
            for j in range(self.n):
                if self.mat[i][j] == 1: return -1
                max_time = max(max_time, self.mat[i][j])
        if max_time == 0: return 0
        return max_time - 2

    def dfs(self, i: int, j: int, time: int):
        if i < 0 or i >= self.m or j < 0 or j >= self.n: return
        if self.mat[i][j] != 1 and self.mat[i][j] < time: return 
        self.mat[i][j] = time
        self.dfs(i+1, j, time + 1)
        self.dfs(i-1, j, time + 1)
        self.dfs(i, j+1, time + 1)
        self.dfs(i, j-1, time + 1)