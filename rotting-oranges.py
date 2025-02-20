# Time Complexity : O(n*m) - n*m is size of the grid
# Space Complexity : O((n*m) - n*m is size of the grid
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
BFS
Maintain count of fresh oranges

Add all the rotten oranges to the queue, and then pop one at a time and add its neighbors
to the queue if it is fresh and also make it rotten and decrement count of fresh oranges by 1
Increment count at each level

If count of fresh orange becomes 0 in the end, return time


"""

from collections import deque
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        m = len(grid)
        n = len(grid[0])

        fresh_count = 0
        queue = deque()

        for i in range(0 ,m):
            for j in range(0 ,n):
                if grid[i][j] == 1:
                    fresh_count += 1
                elif grid[i][j] == 2:
                    queue.append([i ,j])

        directions = [[0 ,1] ,[0 ,-1] ,[1 ,0] ,[-1 ,0]]

        if fresh_count == 0:
            return 0

        time = 0
        while queue:
            if fresh_count == 0:
                return time
            size = len(queue)
            print (queue)
            for i in range(0 ,size):
                orange = queue.popleft()
                r = orange[0]
                c = orange[1]
                for dir in directions:
                    nr = r + dir[0]
                    nc = c + dir[1]
                    if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 1:
                        fresh_count -= 1
                        queue.append([nr ,nc])
                        grid[nr][nc] = 2

            time += 1

        if fresh_count != 0:
            return -1
        else:
            return time -1




