'''
In this problem we need to find the time taken for all the oranges to get rotten, if its not possible return -1.
since we are given 4-adjacent side oranges gets rotten for each minute, I considered a list of 4 directions.
And a fresh variable to calculate the count of fresh oranges present in the grid while checking for the rotten ones.
We start with storing all the rotten oranges first in the queue, if all the oranges are already rotten time taken will be zero.
while iterating on the queue, checking all the 4 direction oranges of they are fresh, they are marked to 2 and thier respective indices are added to the queue.
As we iterate through the grid, for each run time is incremented and fresh oranges are decremented.
'''
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        m = len(grid)
        n = len(grid[0])
        
        # we store row and column index as a pair in a queue
        q = []

        fresh = 0
        # iterating on the grid
        for i in range(m):
            for j in range(n):
                # adding the rotten orange indexes to queue
                if grid[i][j] == 2:
                    q.append((i, j))
                # finding the count of fresh oranges 
                elif grid[i][j] == 1:
                    fresh += 1
        
        time = 0
        if fresh == 0:
            return time

        while q:
            size = len(q)
            
            for i in range(size):
                curr = q.pop(0)
                # neighbors of rotten oranges 
                for dir in dirs:
                    newRow = curr[0] + dir[0]
                    newCol = curr[1] + dir[1]
                    # checking the bounds of newRow and newCol, adding if the orange is fresh and changing it to 2
                    if newRow >= 0 and newCol >= 0 and newRow < m and newCol < n and grid[newRow][newCol] == 1:
                        grid[newRow][newCol] = 2
                        # adding updated cell index to queue
                        q.append((newRow, newCol))
                        # decreasing the count of fresh oranges
                        fresh -= 1
            time += 1 # increasing time for every level

        if fresh == 0: 
            return time - 1 
        return -1

'''
Time Complexity: O(m*n)
since we are iterating on entire grid of size m*n once.
Space Complexity: O(m*n)
In worst case we might have all the oranges are rotten which takes m*n time.
'''