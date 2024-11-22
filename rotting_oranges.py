# Approach:
# 1. Use a Breadth-First Search (BFS) approach to simulate the rotting process.
# 2. Start by adding all initially rotten oranges to the queue with a timestamp of 0.
# 3. Process each orange in the queue and propagate the rot to adjacent fresh oranges, updating their state and adding them to the queue with an incremented timestamp.
# 4. If all fresh oranges are rotted by the end of the process, return the maximum timestamp. Otherwise, return -1.

# Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
# Each cell is processed at most once in the BFS.
# Space Complexity: O(m * n), for the queue used in BFS, which in the worst case may hold all the cells.


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        queue = deque()  # To store the position of rotten oranges and time
        fresh_count = 0  # Count of fresh oranges

        # Step 1: Initialize the queue with all rotten oranges and count fresh oranges
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r, c, 0))  # Append (row, col, time)
                elif grid[r][c] == 1:
                    fresh_count += 1

        # If there are no fresh oranges, return 0
        if fresh_count == 0:
            return 0

        # Directions for moving in the grid (up, down, left, right)
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        time_elapsed = 0

        # Step 2: Perform BFS
        while queue:
            r, c, time = queue.popleft()
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                # Check if adjacent cell is a fresh orange
                if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == 1:
                    grid[nr][nc] = 2  # Mark orange as rotten
                    fresh_count -= 1  # Reduce fresh orange count
                    queue.append((nr, nc, time + 1))  # Add new rotten orange to queue
                    time_elapsed = max(time_elapsed, time + 1)

        # Step 3: Check if there are still fresh oranges left
        return time_elapsed if fresh_count == 0 else -1
