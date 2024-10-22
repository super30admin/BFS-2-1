# 994. Rotting Oranges
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        m = len(grid)
        n = len(grid[0])
        q = deque()
        count = 0
        fresh = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append([i,j])
                if grid[i][j] == 1:
                    fresh += 1

        print(q)

        if fresh == 0:
            return 0

        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                for dir_ in dirs:
                    r = curr[0] + dir_[0]
                    c = curr[1] + dir_[1]

                    if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == 1:
                        grid[r][c] = 2
                        fresh -= 1
                        q.append([r,c])
            count += 1

        if fresh:
            return -1
        return count-1




        