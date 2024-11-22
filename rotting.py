# The orangesRotting method calculates the minimum time required for all fresh oranges to rot in a grid.
# If it is impossible for all fresh oranges to rot, the method returns -1.

# Initialization:
#   - 'ROWS' and 'COLS' store the grid's dimensions.
#   - 'fresh' counts the number of fresh oranges (value 1).
#   - 'time' tracks the time elapsed.

# Step 1: Count Fresh Oranges
#   - Iterate through the grid to count fresh oranges.

# Step 2: Spread Rotting
#   - Use 'directions' to define the four adjacent cells (up, down, left, right).
#   - While there are fresh oranges:
#       - Use a flag to track whether any orange rots in the current step.
#       - For each rotten orange (value 2), spread rot to adjacent fresh oranges (value 1), marking them as "to rot" (value 3).
#       - If no orange rots in a step (flag is False), return -1 as not all oranges can rot.
#       - Update all "to rot" oranges (value 3) to rotten (value 2) for the next step.
#       - Increment 'time' after each step.

# Step 3: Return Time
#   - Once all fresh oranges are rotted, return the elapsed time.

# TC: O(n * m) - Each cell is processed multiple times based on its neighbors.
# SC: O(1) - No extra space is used beyond modifying the grid in place.


from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        fresh = 0
        time = 0

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    fresh += 1

        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        while fresh > 0:
            flag = False
            for r in range(ROWS):
                for c in range(COLS):
                    if grid[r][c] == 2:
                        for dr, dc in directions:
                            row, col = r + dr, c + dc
                            if (row in range(ROWS) and 
                                col in range(COLS) and 
                                grid[row][col] == 1):
                                grid[row][col] = 3  
                                fresh -= 1
                                flag = True

            if not flag:
                return -1

            for r in range(ROWS):
                for c in range(COLS):
                    if grid[r][c] == 3:
                        grid[r][c] = 2  

            time += 1

        return time