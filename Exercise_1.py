# Time Complexity: O(m * n) where m is the number of rows and n is the number of columns in the grid
# Space Complexity: O(m * n) for the visited cells in the worst case
# Were you able to solve the problem? Yes
# Did you face any challenges while solving the problem? No

from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        if not grid:
            return 0

        dirs = [(-1,0), (1,0), (0,-1), (0,1)] # (U,D,L,R)
        fresh=0
        q = deque()
        minutes=0


        m=len(grid)
        n=len(grid[0])

        #initialize and search the grid for fresh and rotten
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    fresh+=1
                elif grid[i][j] == 2:
                    q.append((i,j)) 

        # if there are no fresh oranges, return 0
        if fresh == 0:
            return minutes
        # if there are no rotten oranges to start with, return -1
        if len(q) == 0:
            return -1

        while q:
            # for each minute, process all the rotten oranges
            for _ in range(len(q)):
                # pop the first rotten orange from the queue
                x, y = q.popleft()
                
                # check all four directions for fresh oranges
                # if a fresh orange is found, rot it and add it to the queue
                # also decrement the count of fresh oranges
                for i,j in [(x+_x, y+_y) for _x,_y in dirs ]:
                    if 0<=i<m and 0<=j<n and grid[i][j] == 1:
                        grid[i][j] = 2
                        fresh-=1
                        q.append((i,j))
            # increment the minutes after processing all rotten oranges
            minutes+=1        
                
        # if there are still fresh oranges left, return -1
        return minutes-1 if fresh==0 else -1