"""
APPROACH:
1. Scan the grid to find all initially rotten oranges (add to queue) and count fresh oranges.
2. Use BFS starting from all rotten oranges at once (multi-source BFS), tracking the minute each spread happened.
3. For each rotten orange processed, try to rot its fresh neighbors and add them to the queue with minute+1.
4. Keep track of the maximum minute reached, which represents time for rot to fully spread.
5. After BFS finishes, if any fresh oranges remain unrotted, return -1, otherwise return the total minutes passed.

PATTERN:
Multi-Source Grid BFS

TIME COMPLEXITY:
O(m x n) - every cell is visited and processed at most once

SPACE COMPLEXITY:
O(m x n) - queue can hold up to all cells in the worst case

EXAMPLE:
Input:
grid = [
  [2,1,1],
  [1,1,0],
  [0,1,1]
]

Output: 4
Why: rot spreads outward from the initial rotten orange, taking 4 minutes to reach all fresh oranges
"""

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        rows = len(grid)  # number of rows
        cols = len(grid[0])  # number of columns
        fresh_count = 0  # tracks how many fresh oranges remain
        
        q = collections.deque()  # queue used for BFS

        # scan grid to find all rotten oranges and count fresh ones
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    q.append([r, c, 0])  # rotten orange starts at minute 0
                elif grid[r][c] == 1:
                    fresh_count = fresh_count + 1  # count fresh orange
        
        directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]  # up, down, right, left
        minutes_passed = 0  # tracks total time elapsed

        # BFS spreads rot outward minute by minute from all rotten oranges
        while q:
            r, c, minute = q.popleft()  # process next rotten orange
            minutes_passed = max(minutes_passed, minute)  # update latest time

            # try to rot each neighboring cell
            for direction in directions:
                new_r = r + direction[0]
                new_c = c + direction[1]

                # check neighbor is inside grid bounds
                if new_r >= 0 and new_r < rows and new_c >= 0 and new_c < cols:
                    if grid[new_r][new_c] == 1:
                        grid[new_r][new_c] = 2  # neighbor becomes rotten
                        fresh_count = fresh_count - 1  # one less fresh orange
                        q.append([new_r, new_c, minutes_passed + 1])  # spreads next minute
        
        # if fresh oranges remain, rot could not reach them all
        if fresh_count > 0:
            return -1
        
        return minutes_passed  # total time for rot to fully spread