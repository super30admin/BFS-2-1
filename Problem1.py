"""
Implemented using the technique discussed in the session, where I first add all the rotten oranges to the queue.Then, I use BFS with direction vectors to rot adjacent fresh oranges level by level.This helps track the time taken while ensuring each orange is processed only once.
Time Complexity: O(mn)
Space Complexity: O(mn)
"""
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        rows, cols = len(grid), len(grid[0])
        queue = deque()
        fresh = 0
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r, c))
                elif grid[r][c] == 1:
                    fresh += 1

        if fresh == 0:
            return 0

        directions = [(0,1), (1,0), (-1,0), (0,-1)]
        time = 0

        while queue:
            for _ in range(len(queue)):
                x, y = queue.popleft()
                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < rows and 0 <= ny < cols and grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        queue.append((nx, ny))
                        fresh -= 1
            time += 1

        return time - 1 if fresh == 0 else -1