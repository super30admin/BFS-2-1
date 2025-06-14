# Space Complexity - o(m*n)
# Time Complexity - o(m*n)

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        fresh_count = 0
        q = deque()

        m = len(grid)
        n = len(grid[0])
        directions = [[0,1],[1,0],[0,-1],[-1,0]]
        time = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append([i,j])
                elif grid[i][j] == 1:
                    fresh_count +=1

        if fresh_count == 0:
            return 0

        while q and fresh_count > 0:
            for _ in range(len(q)):
                r, c = q.popleft()
                for dr, dc in directions:
                    gr, gc = r + dr, c + dc
                    if 0 <= gr < m and 0 <= gc < n and grid[gr][gc] == 1:
                        grid[gr][gc] = 2
                        q.append((gr, gc))
                        fresh_count -= 1
            time += 1

        return -1 if fresh_count > 0 else time   
            


        