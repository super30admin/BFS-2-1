#Rotting Oranges

#Time complexity -> O(mxn)
#Space complexity -> O(mxn)
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #Find all the rotten oranges and it's count, meanwhile also count total oranges in the matrix
        # now during each loop rott the neighbors of the rotten oranges and increment the rotten count
        #  in the queue before the loop and also keep adding
        # new rotted oranges. the number of loops required is the total minutes that will be needed to rot all possible oranges
        # in the end if rotten is less then total oranges not all can be rotten

        rottenOranges = deque()
        totalOranges = 0
        rottenOrangesCount = 0
        dir = [(-1,0),(0,1),(1,0),(0,-1)]
        for i in range(0,len(grid)):
            for j in range(0,len(grid[0])):
                val = grid[i][j]
                if val == 0:
                    continue
                if val == 2:
                    rottenOranges.append((i,j))
                    rottenOrangesCount+=1
                totalOranges+=1
        resultMin = 0
        
        while rottenOranges:            
            orangesToRotInCurrentIteration = len(rottenOranges)
            for _ in range(0, orangesToRotInCurrentIteration):
                r,c = rottenOranges.popleft()
                for i,j in dir:
                    if i+r >= 0 and i+r < len(grid) and j+c >= 0 and j+c < len(grid[0]):
                        if grid[i+r][j+c] == 0:
                            continue
                        if grid[i+r][j+c] == 1:
                            grid[i+r][j+c] = 2
                            rottenOrangesCount+=1
                            rottenOranges.append((i+r,j+c))
            if len(rottenOranges) > 0:
                resultMin+=1
        
        if rottenOrangesCount<totalOranges:
            return -1
        return resultMin 


                
