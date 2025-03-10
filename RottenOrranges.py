# Time Complexity : O(M*N)
# Space Complexity : O(M*N)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = 0
        time = 0
        queue =deque()
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1,0], [1,0], [0,-1],[0,1]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append((i, j))
                elif grid[i][j] == 1 :
                    fresh = fresh +1 
        if fresh == 0:
            return 0
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                for dir1 in dirs:
                    nr = curr[0] + dir1[0]
                    nc = curr[1] + dir1[1]
                    if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 1 :
                        queue.append((nr, nc))
                        fresh = fresh -1
                        grid[nr][nc] = 2
            time = time +1
        if fresh != 0:
            return -1 
        return time -1