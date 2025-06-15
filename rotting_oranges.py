#Time Complexity: O(MN)
#Space Complexity: O(MN)
from collections import deque
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        dir_arr = [(0,1),(1,0),(-1,0),(0,-1)]
        queue = deque([])
        m = len(grid)
        n = len(grid[0])
        freshcount = 0
        time = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append((i,j))
                elif grid[i][j] == 1:
                    freshcount += 1
        
        while queue and freshcount > 0:
            size = len(queue)   ## Process level by level
            for i in range(size):
                r,c = queue.popleft()
                print(grid[r][c])
                for dir_ in dir_arr:
                    dr = r + dir_[0]
                    dc = c + dir_[1]
                    if dr >= 0 and dr < m and dc >= 0 and dc < n and grid[dr][dc] == 1:
                        grid[dr][dc] = 2
                        freshcount -= 1
                        queue.append((dr,dc))      
            time += 1
        
        return time if freshcount == 0 else -1 
                
                
        
            
        
        
