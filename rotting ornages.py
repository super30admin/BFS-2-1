class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dirs=[[-1,0],[0,1],[1,0],[0,-1]]
        m=len(grid)
        n=len(grid[0])

        q=[]
        fresh=0

        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    q.append((i,j))
                elif grid[i][j]==1:
                    fresh+=1
        print(q)
        print(fresh)

        time=0
        if fresh==0:
            return time
        while q:
            size=len(q)
            time=time+1
            for i in range(size):
                curr=q.pop(0)
                for dir in dirs:
                    r=curr[0]+dir[0]
                    c=curr[1]+dir[1]

                    if r>=0 and c>=0 and r<m and c<n and grid[r][c]==1:
                        grid[r][c]=2
                        q.append((r,c))
                        fresh=fresh-1

        if fresh==0:
            return time-1           
        else:
            return -1
