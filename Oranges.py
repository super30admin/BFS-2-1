# Time Complexity: O(m*n)
# Spcae Complexity: O(m*n)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        q = deque()
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        time = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    q.append((i,j))
        if fresh == 0:
            return 0
        while q:
            size = len(q)
            for i in range(size):
                cr, cc = q.popleft()
                # Check neighbors of rotten oranges
                for r, c in dirs:
                    nr, nc = cr + r, cc + c
                    # Bound Check
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == 1:
                        fresh -= 1
                        q.append((nr,nc))
                        grid[nr][nc] = 2
            time += 1
        if fresh == 0: return time-1
        return -1
        