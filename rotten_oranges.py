def orangesRotting(self, grid: List[List[int]]) -> int:
    self.dirs=[[-1,0],[0,-1],[0,1],[1,0]]
    self.m=len(grid)
    self.n=len(grid[0])
    q=[]
    fresh=0
    for i in range(self.m):
        for j in range(self.n):
            if grid[i][j]==2:
                q.append((i,j))
            elif grid[i][j]==1:
                fresh+=1

    time=0
    if fresh ==0:
        return time

    while q:
        size=len(q)
        time+=1
        
        for i in range(size):
            curr=q.pop(0)
            for dir in self.dirs:
                r=curr[0]+dir[0]
                c=curr[1]+dir[1]

                if r>=0 and c>=0 and r<self.m and c<self.n and grid[r][c]==1:
                    grid[r][c]=2
                    fresh-=1
                    q.append((r,c))
                    if fresh ==0:
                        return time
    return -1
