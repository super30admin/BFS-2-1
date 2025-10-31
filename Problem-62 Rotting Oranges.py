# 994. Rotting Oranges

# Time Complexity: O(nm)
# Space Complexity: O(nm)

from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        time = 0
        freshCount = 0

        n = len(grid)
        m = len(grid[0])

        q = deque()

        dirs = [(-1, 0), (0, -1), (1, 0), (0, 1)]

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 2:
                    q.appendleft((i, j))
                if grid[i][j] == 1:
                    freshCount += 1

        if freshCount == 0:
            return 0
        
        while q:
            size = len(q)

            for i in range(size):
                curri, currj = q.pop()
                for r, c in dirs:
                    nr = curri + r
                    nc = currj + c

                    if nr >= 0 and nc >= 0 and nr < n and nc < m and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        q.appendleft((nr, nc))
                        freshCount -= 1
            time += 1

        if freshCount == 0:
            return time - 1
        return -1

