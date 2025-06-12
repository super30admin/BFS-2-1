# Time Complexity: O(m * n), where m is the number of rows and n is the number of columns
# Space Complexity: O(m * n), due to the queue used in BFS (worst case: all oranges in queue)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from collections import deque
from typing import List

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return -1

        rows = len(grid)
        cols = len(grid[0])
        q = deque()
        fresh = 0

        # Step 1: Add all initially rotten oranges to the queue and count fresh oranges
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    q.append((r, c))
                elif grid[r][c] == 1:
                    fresh += 1

        # No fresh oranges to rot
        if fresh == 0:
            return 0

        time = 0  # Time counter

        # Step 2: BFS to rot adjacent fresh oranges
        while q and fresh > 0:
            for _ in range(len(q)):
                i, j = q.popleft()
                for r, c in [(i+1, j), (i, j+1), (i-1, j), (i, j-1)]:
                    if 0 <= r < rows and 0 <= c < cols and grid[r][c] == 1:
                        grid[r][c] = 2  # Rot the fresh orange
                        fresh -= 1
                        q.append((r, c))
            time += 1

        # If there are still fresh oranges left, return -1
        return time if fresh == 0 else -1

# ---------------------------------------------------------------------------
        # Brute Force Approach (Naive) using deepcopy
        # Time Complexity: O((m * n)^2) in worst case — each round we may scan whole grid
        # Space Complexity: O(m * n) due to copy of grid in every round

        # import copy
        # def orangesRotting(grid):
        #     rows = len(grid)
        #     cols = len(grid[0]) if grid else 0
        #     minutes = 0

        #     while True:
        #         changed = False
        #         temp_grid = copy.deepcopy(grid)
        #         for i in range(rows):
        #             for j in range(cols):
        #                 if grid[i][j] == 2:
        #                     for dx, dy in [(-1,0), (1,0), (0,-1), (0,1)]:
        #                         ni, nj = i + dx, j + dy
        #                         if 0 <= ni < rows and 0 <= nj < cols and grid[ni][nj] == 1:
        #                             temp_grid[ni][nj] = 2
        #                             changed = True
        #         if not changed:
        #             break
        #         grid = temp_grid
        #         minutes += 1

        #     for row in grid:
        #         if 1 in row:
        #             return -1
        #     return minutes
