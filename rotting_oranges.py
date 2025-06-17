###
# Approach:
# - Perform multi-source BFS from all initially rotten oranges (value = 2).
# - Track the time it takes to rot each fresh orange (value = 1).
# - At each step, spread the rot to adjacent fresh oranges (up/down/left/right).
# - Count how many fresh oranges exist and reduce the count as they rot.
# - If all fresh oranges are rotted by the end, return the time; otherwise, return -1.
#
# Time Complexity: O(m * n) — visit each cell once
# Space Complexity: O(m * n) — for queue and grid
###

from collections import deque
class Solution:
    def orangesRotting(self, grid):
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        fresh_oranges = 0
        queue = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append(((i,j), 0))
                elif grid[i][j] == 1:
                    fresh_oranges += 1
        if fresh_oranges == 0:
            return 0
        time = 0
        while queue:
            (r,c), t = queue.popleft()
            ngh = [[0,1],[1,0], [0,-1], [-1,0]]
            time = max(t, time)
            for ng in ngh:
                nr = r + ng[0]
                nc = c + ng[1]
                if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == 1:
                    grid[nr][nc] = 2
                    fresh_oranges -= 1
                    queue.append(((nr,nc), time+1))
        return time if fresh_oranges == 0 else -1
    
    def main(self):
        # Example 1
        grid1 = [
            [2,1,1],
            [1,1,0],
            [0,1,1]
        ]
        # Expected output: 4
        print("Time to rot all oranges (grid1):", self.orangesRotting(grid1))

        # Example 2
        grid2 = [
            [2,1,1],
            [0,1,1],
            [1,0,1]
        ]
        # Expected output: -1 (some oranges can't be reached)
        print("Time to rot all oranges (grid2):", self.orangesRotting(grid2))

        # Example 3
        grid3 = [
            [0,2]
        ]
        # Expected output: 0 (no fresh oranges)
        print("Time to rot all oranges (grid3):", self.orangesRotting(grid3))

# Run the solution
sol = Solution()
sol.main()
