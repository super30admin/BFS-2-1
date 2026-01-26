#----------------Solution 1 : BFS -----------
''' Time Complexity : O(m*n) 
    Space Complexity : O(m*n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        q = deque()
        time = 0
        fresh = 0
        #add all rotten oranges to queue
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    q.append((i,j))
        
        if fresh == 0:
            return time

        while q:
            size = len(q)
            time += 1
            for _ in range(size):
                i,j = q.popleft()
                dirr = [(i,j-1),(i,j+1),(i-1,j),(i+1,j)]
                for r,c in dirr:
                    if 0<=r<rows and 0<=c<cols and grid[r][c] == 1:
                        q.append((r,c))
                        grid[r][c] = 2
                        fresh -= 1

                        if fresh == 0:
                            return time
        return -1

#----------------Solution 2 : DFS -----------
''' Time Complexity : O(m*n) 
    Space Complexity : O(m*n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:        
    def orangesRotting(self, grid: List[List[int]]) -> int:

        self.rows, self.cols = len(grid), len(grid[0])
        
        for i in range(self.rows):
            for j in range(self.cols):
                if grid[i][j] == 2:
                    self.dfs(grid, i, j, 2)
    
        result = 2
        for i in range(self.rows):
            for j in range(self.cols):
                if grid[i][j] == 1:
                    return -1
                else:
                    result = max(result,grid[i][j])
        
        return result - 2

    def dfs(self, grid, i,j, time):
        #base
        if grid[i][j] != 1 and grid[i][j] < time:
            return
        #logic
        grid[i][j] = time
        dirr = [(i,j-1),(i,j+1),(i-1,j),(i+1,j)]
        for r,c in dirr:
            if 0<=r<self.rows and 0<=c<self.cols:
                self.dfs(grid, r,c,time+1)