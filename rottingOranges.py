class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # T: O(m * n), S: O(m * n)

        rows, cols = len(grid), len(grid[0])
        queue = deque()
        fresh_count = 0

        # Step 1: Add all rotten oranges to the queue and count fresh oranges
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r, c, 0))  # (row, col, minutes)
                elif grid[r][c] == 1:
                    fresh_count += 1

        # Directions for 4-way adjacent cells (up, down, left, right)
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        minutes_passed = 0

        # Step 2: BFS to rot adjacent fresh oranges
        while queue:
            r, c, minutes = queue.popleft()
            minutes_passed = max(minutes_passed, minutes)

            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == 1:
                    grid[nr][nc] = 2  # Mark fresh orange as rotten
                    fresh_count -= 1
                    queue.append((nr, nc, minutes + 1))

        # Step 3: If fresh oranges remain, return -1; otherwise, return time taken
        return -1 if fresh_count > 0 else minutes_passed
