class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        if len(grid) == 0 or len(grid[0]) == 0 or grid is None:
            return -1
        
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        time = 0
        q = deque()
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append([i,j])
                if grid[i][j] == 1:
                    fresh += 1

        if fresh == 0:
            return 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for dire in dirs:
                    nr = curr[0] + dire[0]
                    nc = curr[1] + dire[1]
                    if nr>=0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == 1:
                        q.append([nr,nc])
                        grid[nr][nc] = 2
                        fresh -= 1
            
            time += 1

        if fresh != 0:
            return -1
        return time - 1
        