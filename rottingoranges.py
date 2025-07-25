# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

from collections import deque


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dirs = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        m = len(grid)
        n = len(grid[0])
        queue = deque()
        fresh = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append((i, j))
                if grid[i][j] == 1:
                    fresh += 1
        time = 0
        if fresh == 0:
            return time

        while queue:
            size = len(queue)
            time += 1
            for i in range(size):
                curr = queue.popleft()
                for j in dirs:
                    row = curr[0] + j[0]
                    col = curr[1] + j[1]

                    if (row >= 0 and col >= 0 and row < m and col < n and grid[row][col] == 1):
                        queue.append((row, col))
                        grid[row][col] = 2
                        fresh -= 1
        return time - 1 if fresh == 0 else -1
