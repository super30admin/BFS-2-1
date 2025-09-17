"""
TC: O(N*M) {we visit each cell in the grid at most once}
SC: O(N*M) {in the worst case, all cells could contain a rotten orange, and we store all of them in the queue}

Approach:

We solve this problem using a Breadth-First Search (BFS) approach. This is an ideal approach for finding the shortest time required for a process to complete, as BFS explores all nodes at the present "depth" or "level" before moving on to the nodes at the next depth level.

First, we perform an initial scan of the entire `N x M` grid. We count the total number of fresh oranges and add the initial rotten oranges' coordinates to a queue. If there are no fresh oranges to begin with, the time required is zero.

The BFS simulation proceeds in "minutes" or "levels". In each iteration of the `while` loop, we process all oranges that became rotten in the previous minute. We iterate through the current level of the queue, dequeueing each rotten orange. For each rotten orange, we check its four adjacent neighbors (up, down, left, and right).

If a neighbor is a fresh orange, we "rot" it by changing its value to 2, decrement the `fresh_count`, and enqueue its coordinates. This process simulates the spread of rot. We increment our time counter (`mins`) only at the end of each level, representing one minute passing.

After the BFS is complete, we check if all fresh oranges have been rotted (`fresh_count == 0`). If so, we return the total minutes elapsed. Otherwise, if there are still fresh oranges left, it means they were unreachable, and we return -1.

The problem ran successfully on LeetCode.
"""

from typing import List
from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        def inBounds(x,y):
            return 0<=x<n and 0<=y<m

        n,m = len(grid), len(grid[0])
        fresh_count = 0
        q = deque()

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    fresh_count += 1
                elif grid[i][j] == 2:
                    q.append((i, j))

        nei = [[0,1], [1,0], [-1,0], [0,-1]]

        mins = 0

        while q:

            for i in range(len(q)):

                x, y = q.popleft()

                for dx, dy in nei:
                    nx, ny = x + dx, y + dy
                    if inBounds(nx, ny) and grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        fresh_count -= 1
                        q.append((nx, ny))
            if q:
                mins += 1

        if fresh_count == 0:
            return mins
        
        return -1  