from collections import deque


class Solution:
    def orangesRotting(self, grid):
        neighbours = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        rows, cols = len(grid), len(grid[0])
        q = deque()
        fresh = 0
        for r in range(rows):
            for c in range(cols):
                curr = grid[r][c]
                if curr == 2:
                    q.append((r, c))
                elif curr == 1:
                    fresh += 1
        if fresh == 0:
            return 0
        time = 0
        while q:
            qs = len(q)
            for _ in range(qs):
                cr, cc = q.popleft()
                for x, y in neighbours:
                    nr, nc = cr + x, cc + y
                    if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == 1:
                        fresh -= 1
                        grid[nr][nc] = 2
                        q.append((nr, nc))
                    if fresh == 0:
                        return time + 1
            time += 1
        if fresh > 0:
            return -1
        return time - 1
