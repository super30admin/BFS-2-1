# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition is to do a BFS from all the cells that have rotten oranges. Increase the time for each level.
# Since, after the level is over we are incrementing the time by 1. Hence, for the last iteration which we don't
# have to we still increment. So final result should be time - 1

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = deque()
        fresh = 0
        m = len(grid)
        n = len(grid[0])
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        time = 0

        for r in range(m):
            for c in range(n):
                if grid[r][c] == 1:
                    fresh += 1
                elif grid[r][c] == 2:
                    queue.append((r, c))

        if fresh == 0:
            return 0

        while queue:
            size = len(queue)
            for _ in range(size):
                r, c = queue.popleft()
                for x, y in directions:
                    nr = x + r
                    nc = y + c
                    if nr < 0 or nc < 0 or nr == m or nc == n or grid[nr][nc] != 1:
                        continue
                    grid[nr][nc] = 2
                    fresh -= 1
                    queue.append((nr, nc))
            time += 1
        if fresh == 0:
            return time - 1
        return -1
