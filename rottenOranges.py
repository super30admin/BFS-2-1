class BFSSolution:
# Time Complexity : O(MXN) where M is number of rows and N is number of columns
# Space Complexity : O(MXN) where M is number of rows and N is number of columns
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

    # BFS SOlution
    def orangesRotting(self, grid: list[list[int]]) -> int:
        from collections import deque
        q = deque()
        m = len(grid) # no of rows
        n = len(grid[0]) # no of columns
        neighbors = [[-1,0],[0,-1],[0,1],[1,0]] # top, left, right, bottom
        fresh = 0
        # Adding all the indexes where we have rotten oranges
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append((i,j))
                elif grid[i][j] == 1:
                    fresh += 1

        if fresh == 0: # if there are no fresh oranges then we dont need to wait so
            return 0
        
        # initializing minutes
        minutes = 0
        conversion_count = 0

        while len(q): # Iterating until queue is empty
            size = len(q) # snapshot for minutes/level
            minutes += 1 # Increasing minute at each level
            for i in range(size): 
                curr = q.popleft()
                # checking neighbors
                for neighbor in neighbors:
                    x_neighbor = curr[0] + neighbor[0] # x coordinate of neighbor
                    y_neighbor = curr[1] + neighbor[1] # y coordinate of neighbor
                    if x_neighbor >=0 and y_neighbor >= 0 and x_neighbor < m and y_neighbor < n and grid[x_neighbor][y_neighbor] == 1:
                        grid[x_neighbor][y_neighbor] = 2 # Convert the orange to rotton
                        q.append((x_neighbor,y_neighbor)) # add it to queue 
                        conversion_count += 1 # increase counter for rotten oranges

        if fresh == conversion_count: # if all the fresh oranges are converted to rotten then return minutes-1 else return -1
            return minutes-1
        return -1
    
class Solution:
# Time Complexity : OK(MXN) where M is number of rows and N is number of columns
# Space Complexity : O(MXN) where M is number of rows and N is number of columns
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, dfs recursion, how to enter with offset
    # DFS
    def __init__(self):
        self.conversion_count = 0
        self.dirs = [[-1,0],[0,-1],[0,1],[1,0]]
        self.m = 0
        self.n = 0
    
    def orangesRotting(self, grid: list[list[int]]) -> int:
        self.m = len(grid)
        self.n = len(grid[0])
        fresh = 0 
        offset = 2
        minutes = 2

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 1:
                    fresh += 1

        if fresh == 0 :
            return 0
        
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 2:
                    self.dfs(grid, i, j, offset)

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 1:
                    return -1
                minutes = max(minutes, grid[i][j])
        
        return minutes - offset
        
    def dfs(self, grid: list[list[int]], i: int, j: int, depth: int)-> None:
        grid[i][j] = depth
        for direction in self.dirs:
            r = direction[0] + i
            c = direction[1] + j
            if r >= 0 and c >= 0 and r < self.m and c < self.n and (grid[r][c] == 1 or grid[r][c] > depth):
                self.dfs(grid, r, c, depth+1)