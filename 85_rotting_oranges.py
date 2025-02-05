# Time complexity - O(m * n)
# Space complexity - O(m * n)

# Approach - bfs - Maintain the count of initial fresh oranges and the number of total fresh oranges that
# were able to converted to rotten once we traverse the grid. Also need to maintain the level in the queue
# since we need to know the total time (every level = 1 min) taken to convert fresh oranges rotten.

from queue import Queue
from typing import List
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None or len(grid) == 0:
            return -1

        m = len(grid)
        n = len(grid[0])
        q = Queue()
        count = 0 # total number of fresh oranges

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.put((i,j))
                elif grid[i][j] == 1:
                    count += 1
        
        if count == 0:
            return 0
        
        dirs = [[0,1], [0,-1], [1,0], [-1,0]] # R, L, U, D
        time = 0 # level of queue
        count2 = 0 # num of fresh oranges that we're able to convert to rotten
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get() # (i, j)
                for d in dirs:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]

                    if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == 1:
                        q.put((nr, nc))
                        grid[nr][nc] = 2
                        count2 += 1
            time += 1

        if count2 == count:
            return time-1
        else:
            return -1