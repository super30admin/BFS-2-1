'''
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
'''
# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # We can  use BFS - 1. Add all the rotten to queue. Have time & fresh_count variables
        # 2. process one level at a time, update each node when we add to queue for processing, -- fresh_count & ++ time for each level
        m, n = len(grid), len(grid[0])
        dirs = [[0, -1], [1, 0], [0, 1], [-1, 0]]
        fresh_count = 0
        time = 0
        q = deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh_count += 1
                elif grid[i][j] == 2:
                    q.append([i, j])
        if fresh_count == 0: return 0
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                # explore neighbors using directions array (also used in game of life)
                for dr, dc in dirs:
                    # new row, new col
                    nr, nc = curr[0] + dr, curr[1] + dc
                    # check bounds
                    if nr >= 0 and nc >= 0 and nr < m and nc <n and grid[nr][nc] == 1:
                    
                        #reduce fresh count by 1 and update value to 2 before putting it in the queue
                        fresh_count -= 1
                        grid[nr][nc] = 2
                        q.append([nr, nc])
            time += 1
        
        if fresh_count == 0:
            return time - 1
        return -1

