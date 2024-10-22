class Solution(object):
    direction = []
    m = 0
    n = 0
    def orangesRotting(self, grid): #DFS T.C->0(N), S.C -> O(H)
        self.direction = [[-1,0],[1,0],[0,-1],[0,1]]
        self.m = len(grid)
        self.n = len(grid[0])
        time = 2
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 2:
                    self.dfs(grid,i,j,time)
        print(grid)
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 1:
                    return -1
                time = max(time,grid[i][j])
        return time-2

    def dfs(self,grid,i,j,time):
        grid[i][j] = time
        
        for dir in self.direction:
            nr = i + dir[0]
            nc = j + dir[1]

            if nr >= 0 and nc >=0 and nr < self.m and nc < self.n and (grid[nr][nc] == 1 or grid[nr][nc] > time):
                self.dfs(grid,nr,nc,time+1)
        

        