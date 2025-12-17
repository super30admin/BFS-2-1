# https://leetcode.com/problems/rotting-oranges

# Time Complexity- O(m * n) Space Complexity- O(m * n)
from collections import deque
class Solution:
    def orangesRotting(self, grid: list[list[int]]) -> int:
        # initialising the direction
        self.dirs = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        self.m = len(grid)
        self.n = len(grid[0])
        # initialising the fresh oranges as zero
        fresh = 0

        # initialisign the dequeue
        q = deque()

        # interate over the matrix to find the first rotten orange and append into the dequeue and count the fresh oranges
        for i in range(self.m):
            for j in range(self.n):
                # check if the orange is rotten
                if grid[i][j] == 2:
                    # and take that orange into the queue
                    q.append((i,j))
                # check if the orange is fresh
                elif grid[i][j] == 1:
                    # increase the counter
                    fresh += 1
        # intialise the time
        time = 0
        # edge case- if there are no fresh oranges then no need to go further, return the time
        if fresh == 0:
            return time
        
        # now go through the dequeue level by level, here one level acts a minute
        while q:
            size = len(q)
            time += 1
            # process only those oranges which are rotten at first
            for i in range(size):
                # remove that fromt the deque
                curr = q.popleft()
                # iterate over the dir array to check which orange can rot
                for dir in self.dirs:
                    # check the rows
                    r = curr[0] + dir[0]
                    # check the columns
                    c = curr[1] + dir[1]
                    # base cases to check out of bounce and orange is fresh
                    if r >= 0 and c >= 0 and r < self.m and c  < self.n and grid[r][c] == 1:
                        # rot the orange
                        grid[r][c] = 2
                        # add into the dequeu
                        q.append((r,c))
                        # decrease the fresh count
                        fresh -= 1
                        # when fresh becomes zero 
                        if fresh == 0:
                            # return the time
                            return time
        return -1


S = Solution()
print(S.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))