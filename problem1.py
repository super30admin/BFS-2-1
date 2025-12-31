"""
We have to adjust time as well, so we have a time variable that increments after each fresh (1) orange is turned into a rotten (2). in the queue we first append the rotten oranges
and then perform bfs on them by exploring all the directions around the grid
TC is O(m X n) and SC is also O(m X n) if all the given oranges are rotten
"""

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rows = len(grid)
        cols = len(grid[0])
        time, fresh = 0, 0
        directions = [(0, 1), (1,0), (0, -1), (-1,0)]

        q = deque()
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    q.append((r,c))
                if grid[r][c] == 1:
                    fresh += 1
        if fresh == 0:
            return 0

        while q:
            newrot = False
            for x in range(len(q)):
                r, c = q.popleft()
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if (0 <= nr < rows and
                        0 <= nc < cols and 
                        grid[nr][nc] == 1):
                        grid[nr][nc] = 2
                        fresh -= 1
                        q.append((nr, nc))
                        newrot = True
            if newrot:
                time += 1

        return time if fresh == 0 else -1
