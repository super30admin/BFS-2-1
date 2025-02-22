# Problem 1 : Rotting Oranges
# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # variables to store fresh orange count and time 
        fresh = 0
        time = 0
        queue = deque()

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                # counting the fresh orange
                if grid[i][j] == 1:
                    fresh += 1
                # if the orange is rotten then append row, col in the qeueue
                elif grid[i][j] == 2:
                    queue.append([i, j])
        # direction array
        direction = ([1,0], [-1,0], [0,1], [0,-1])
        while queue and fresh > 0:
            # loop for level wise in the bfs
            for i in range(len(queue)):
                row, col = queue.popleft()
                for r, c in direction:
                    cr = row + r
                    cc = col + c
                    # check the boundary condition and if the orange is fresh 
                    if (0 <= cr < len(grid) and 0 <= cc <len(grid[0]) and grid[cr][cc] == 1):
                    
                        # mark that orange as rotten, append the row and col in the queue and decrement the fresh count
                        grid[cr][cc] = 2
                        fresh -= 1
                        queue.append([cr,cc])
            # increment the time after the level is processed
            time += 1
        # return the time if the fresh count is 0 else return -1
        return time if fresh == 0 else -1

        