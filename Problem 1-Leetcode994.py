#Time Complexity: O(m*n)
#Space Complexity: O(m*n)

from collections import deque
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        dirs = [(-1, 0), (1, 0), (0, 1), (0, -1)]
        m, n = len(grid), len(grid[0])
        q = deque()
        fresh = 0
        # Add all rotten oranges to queue
        # Count all fresh oranges
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2: q.append((i, j))
                elif grid[i][j] == 1: fresh += 1

        # No fresh oranges
        if fresh == 0: return 0

        time = 0
        while q:
            size = len(q)
            time += 1
            for i in range(size):
                row, col = q.popleft()
                for dr, dc in dirs:
                    r = row + dr
                    c = col + dc
                    if (r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == 1):
                        grid[r][c] = 2
                        fresh -= 1
                        q.append((r, c))
                        if fresh == 0: return time
        return -1
        