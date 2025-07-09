# Time Complexity : O(m * n), where m is the number of rows and n is the number of columns
# Space Complexity : O(m * n), for the queue used in BFS
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used a Breadth-First Search (BFS) approach.
# I first added all initially rotten oranges to a queue.
# Then, I processed the queue level by level (minute by minute), and rotted adjacent fresh oranges.
# I tracked the time taken and the count of fresh oranges.
# If all fresh oranges were rotted, I returned the total time; otherwise, I returned -1.

from collections import deque
from typing import List

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        queue = deque()
        fresh_count = 0

        # I scanned the grid for initial state
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r, c))
                elif grid[r][c] == 1:
                    fresh_count += 1

        if fresh_count == 0:
            return 0  # No fresh oranges to begin with

        minutes = 0
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        while queue:
            size = len(queue)
            changed = False  # I used this to track whether any orange rotted in this round

            for _ in range(size):
                x, y = queue.popleft()

                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < rows and 0 <= ny < cols and grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        queue.append((nx, ny))
                        fresh_count -= 1
                        changed = True

            if changed:
                minutes += 1  # I only incremented time if any oranges rotted this minute

        return minutes if fresh_count == 0 else -1
