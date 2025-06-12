# Time Complexity: O(M * N), M * N is the size of the grid
# Space Complexity: O(M * N)
# Did this code successfully run on Leetcode: Yes

from typing import List
from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        fresh = 0
        time = 0
        m = len(grid)
        n = len(grid[0])
        queue = deque()

        for row in range(m):
            for col in range(n):
                if grid[row][col] == 1:
                    fresh += 1
                elif grid[row][col] == 2:
                    queue.append([row, col])
        
        if fresh == 0:
            return time
        
        while len(queue):
            size = len(queue)

            for _ in range(size):
                popped = queue.popleft()

                for direction in directions:
                    new_row = popped[0] + direction[0]
                    new_col = popped[1] + direction[1]

                    if new_row >= 0 and new_row < m and new_col >= 0 and new_col < n:
                        if grid[new_row][new_col] == 1:
                            queue.append([new_row, new_col])
                            grid[new_row][new_col] = 2
                            fresh -= 1
            
            time += 1

        if fresh == 0:
            return time - 1
        
        return -1
