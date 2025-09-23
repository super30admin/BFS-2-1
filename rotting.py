# Time Complexity : O(M*N) where M is the number of rows and N is the number of columns in the grid
# Space Complexity : O(M*N) where M is the number of rows and N is the number of columns in the grid
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using DFS to traverse the grid. I am starting from each rotten orange and marking the adjacent fresh oranges as rotten.
# I am using the grid itself to keep track of the time taken to rot each orange.
# I am having an offset of 2 to differentiate between fresh and rotten oranges.
# I am traversing in all 4 directions from each rotten orange and marking the adjacent fresh oranges as rotten with time + 1.
# Finally, I am checking if there are any fresh oranges left. If there are, I return -1. Otherwise, 
# I return the maximum time taken to rot all oranges.


from typing import List
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        res = 2
        def dfs(r,c,time):
            if r < 0 or c < 0 or r == m or c == n:
                return 
            if grid[r][c] < time and grid[r][c] != 1:
                return 
            grid[r][c] = time
            for dr,dc in dirs:
                nr = dr + r
                nc = dc + c
                dfs(nr,nc,time + 1)
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    dfs(i,j,2)
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    return -1
                else:
                    res = max(res,grid[i][j])
        return res - 2


    