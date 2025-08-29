# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english: This code solves the Rotting Oranges problem using BFS. It first counts fresh oranges and enqueues all initially rotten ones, then spreads the rot level by level (minute by minute) to adjacent fresh oranges. If all fresh oranges eventually rot, it returns the time taken; otherwise, it returns -1 if some remain unreachable.

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.m = len(grid)
        self.n = len(grid[0])
        fresh = 0

        q = []

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 2:
                    q.append((i, j))
                elif grid[i][j] == 1:
                    fresh += 1
        
        time = 0
        if fresh == 0:
            return time
        
        while q:
            size = len(q)
            time += 1
            for i in range(size):
                curr = q.pop(0)
                for dir in self.dirs:
                    nr = curr[0] + dir[0]
                    nc = curr[1] + dir[1]

                    if nr >= 0 and nc >= 0 and nr < self.m and nc < self.n and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        q.append((nr, nc))
                        fresh -= 1
                        if fresh == 0:
                            return time

        return -1  
