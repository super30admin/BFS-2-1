# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS. Initialize a queue and iterate over the grid to find the rotten oranges and append the index i and j to queue
# If there is a fresh orange increment fresh by one
# If after iterating over the grid there is no fresh orange at all then return there itself
# Until queue is empty iterate over the queue and pop the indexes i and j
# Initialize a list of tuples with the 4 directions or neighbors
# Iterate over the neighbors and get the row and col index by adding i and j with each neighbor
# Check the boundaries of row and col and check if the orange is fresh then append it to queue and make current one rotten and decrement the fresh by one
# Increment the time by one until for each level until the queue is not empty
# Then check after incrementing the time if there is any fresh orange left if not return time
# In the end return -1

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        fresh = 0
        time = 0
        queue = deque()
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    queue.append((i,j))
        if fresh == 0:
            return 0
        dirs = {(0,1), (1,0), (0,-1), (-1,0)}
        while queue:
            size = len(queue)
            for i in range(size):
                row, col = queue.popleft()
                for dir in dirs:
                    r = row + dir[0]
                    c = col + dir[1]
                    if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == 1:
                        grid[r][c] = 2
                        fresh -= 1
                        queue.append((r,c))
            time += 1
            if fresh == 0:
                return time
        return -1
#BFS

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        self.m = len(grid)
        self.n = len(grid[0])
        self.dirs = {(0,1), (1,0), (-1,0), (0,-1)}
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 2:
                    self.helper(grid, i, j, 2)
        result = 2
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 1:
                    return -1
                result = max(result, grid[i][j])
        return result - 2

    def helper(self, grid, r, c, time):
        if r < 0 or r == self.m or c < 0 or c == self.n:
            return 
        if grid[r][c] < time and grid[r][c] != 1:
            return
        grid[r][c] = time
        for dir in self.dirs:
            row = r + dir[0]
            col = c + dir[1]
            self.helper(grid, row, col, time + 1)
            
        



        