# Time Complexity : O(m * n), m is no of rows and n is no of columns
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# we use BFS because of connected components
# and we add independent variable in the queue
# using dirs list to traverse all 4 neighbours 


from collections import deque
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if grid is None:
            return None
        
        fresh = 0
        time = 0
        q = deque()
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        # traverse the matrix to find the count of fresh oranges
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    # add to queue
                    q.append([i,j])
                elif grid[i][j] == 1:
                    fresh += 1
        
        if fresh == 0:
            # no fresh oranges in the gien grid
            return 0
        
        # bfs
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft() # coordinates of a rotten orange
                # look at the adjacent elements
                for dir in dirs:
                    nr = curr[0] + dir[0]
                    nc = curr[1] + dir[1]
                    if nr >= 0 and nr < m and nc >= 0 and nc < n:
                        if grid[nr][nc] == 1:
                            q.append([nr,nc])
                            fresh -= 1
                            grid[nr][nc] = 2
                
            time += 1
        if fresh != 0:
            return -1
        
        else:
            return time - 1




        