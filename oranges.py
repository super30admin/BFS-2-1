# Time complexity: O(mn)
# Space complexity: O(mn)

from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        rows, cols = len(grid), len(grid[0])
        queue = deque()
        fresh = 0
        visited = [[False]*cols for _ in range(rows)]
        
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r, c))
                    visited[r][c] = True
                elif grid[r][c] == 1:
                    fresh += 1
                else:
                    visited[r][c] = True
        
        if fresh == 0:
            return 0
        
        minutes = 0
        while queue:
            for _ in range(len(queue)):
                x, y = queue.popleft()
                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < rows and 0 <= ny < cols and grid[nx][ny] == 1 and not visited[nx][ny]:
                        queue.append((nx, ny))
                        visited[nx][ny] = True
                        fresh -= 1
            minutes += 1
        
        return minutes - 1 if fresh == 0 else -1
