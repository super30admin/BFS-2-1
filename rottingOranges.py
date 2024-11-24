"""
TC: O(N*M) to iterate over grid 
SP: O(N*M) if all oranges are rotten in the worst case
"""

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque()
        rows, cols = len(grid), len(grid[0])
        directions = [(-1,0), (1, 0), (0,-1), (0,1)]
        fresh_count = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] ==2:
                    q.append((i, j))
                if grid[i][j] ==1:
                    fresh_count+=1
        if fresh_count==0:
            return 0
        level = 0
        while q:
            for i in range(len(q)):
                r,c = q.popleft()
                for dr, dc in directions:
                    nr, nc = dr+r, dc+c
                    if 0<=nr<rows and 0<=nc<cols and grid[nr][nc]==1:
                        grid[nr][nc]=2
                        fresh_count-=1
                        q.append((nr,nc))
            level+=1
        return level-1 if fresh_count==0 else -1




            

        