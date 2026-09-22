# LEETCODE PROBLEM : 994. ROTTING ORANGES
# TIME COMPLEXITY: O(N*M) where N is the row and M is the column 
# SPACE COMPLEXITY: O(N*M) where N is the row ans M is the column

class Solution:
    def orangesRotting(self, grid: list[list[int]]) -> int:
        fresh_orange=0
        row=len(grid)
        col=len(grid[0])
        queue=deque()

        for i in range(row):
            for j in range(col):
                if grid[i][j]==2:
                    queue.append((i,j,0))
                elif grid[i][j]==1:
                    fresh_orange+=1
        time=0
        while queue:
            r,c,t=queue.popleft()
            time=t
            for dx,dy in [(1,0),(0,1),(0,-1),(-1,0)]:
                nr,nc=r+dx, c+dy
                if 0<=nr<row and 0<=nc<col and grid[nr][nc]==1:
                    grid[nr][nc]=2
                    fresh_orange-=1
                    queue.append((nr,nc,t+1))
        return time if fresh_orange==0 else -1
