"""
Approach: go level by level to increment time and rot the fresh oranges and return the time as soon as
fresh oranges = 0. Use BFS 
t.c. => O(m * n)
s.c. => will be at max O(min(m, n)) which is the diagonal
"""
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]

        def helper(i, j, time):
            
            if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == 0 or (time != 3 and grid[i][j] == 2) or (grid[i][j] > 2 and grid[i][j] <= time):
                return

            grid[i][j] = time
            for x, y in directions:
                helper(x + i, y + j, time + 1)
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    helper(i, j, 3)
        maxNum = 3
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    return -1
                maxNum = max(grid[i][j], maxNum)
 
        return maxNum - 3
            