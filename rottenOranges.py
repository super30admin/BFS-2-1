# Time: O(m*n) for matrix
# Space: O(m*n) for queue
# Leetcode: Yes
# Issues: If no rotten or fresh oranges present exit //

from collections import deque

class Solution:

    def orangesRotting(self, grid: List[List[int]]) -> int:
        dirs = [(-1,0),(1,0),(0,-1),(0,1)]
        m = len(grid)
        n = len(grid[0])
        time = 0
        fresh = 0

        q = deque()
        # first traversal add all rotten(index 2) to the queue
        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:               # rotten in queue
                    q.append((i,j))
                elif grid[i][j]==1:             # keep fresh count
                    fresh +=1

        if fresh == 0 :                         # no fresh oranges to rot? // main condition for [[0]]
            return time                  

        while q:                                    # rotten apples
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for di in dirs:                     # rot in 4 direcrions
                    r = curr[0] + di[0]
                    c = curr[1] + di[1]

                    if 0 <= r < m and 0 <= c < n:   # 4 sides to rot are inbounds
                        if grid[r][c] == 1:         # fresh apple? 
                            grid[r][c] = 2          # rot it
                            q.append((r,c))         # rotten in queue
                            fresh -=1               # decrement fresh
            time +=1

        return -1 if fresh > 0 else time-1
