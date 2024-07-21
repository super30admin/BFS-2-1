from collections import deque

def orangesRotting(grid):
    rows, cols = len(grid), len(grid[0])
    queue = deque()
    fresh_count = 0

    # Initialize the queue with all rotten oranges and count fresh oranges
    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == 2:
                queue.append((r, c, 0))  # (row, col, time)
            elif grid[r][c] == 1:
                fresh_count += 1

    # Directions array for moving in 4 possible directions
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    minutes_elapsed = 0

    # Perform BFS
    while queue:
        r, c, minutes_elapsed = queue.popleft()
        
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == 1:
                grid[nr][nc] = 2
                fresh_count -= 1
                queue.append((nr, nc, minutes_elapsed + 1))

    # If there are fresh oranges left, return -1
    if fresh_count > 0:
        return -1

    return minutes_elapsed

# Example usage:
grid = [
    [2, 1, 1],
    [1, 1, 0],
    [0, 1, 1]
]
print(orangesRotting(grid))  # Output: 4