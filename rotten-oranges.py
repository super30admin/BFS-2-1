class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = deque()
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        ROWS, COLS = len(grid), len(grid[0])
        res = 0
        infected = False

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 2:
                    queue.append((r, c))

        while queue:
            level = len(queue)
            infected = False
            while level > 0 and queue:
                cr, cc = queue.popleft()
                for dr, dc in directions:
                    r = cr + dr
                    c = cc + dc
                    if 0 <= r < ROWS and 0 <= c < COLS and grid[r][c] == 1:
                        grid[r][c] = 2
                        infected = True
                        queue.append((r, c))
                level -= 1
            if infected:
                res += 1

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    return -1
        if res == -1:
            return 0
        return res
