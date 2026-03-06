# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Collect all the rotten oranges and count how many fresh ones are there.
# Then, every minute, rot the nearby fresh ones using BFS until none are left.
# If we finish rotting all, return the time; else, return -1 since some can't be reached.

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols, fresh = len(grid), len(grid[0]), 0
        dirs = [[-1,0],[1,0],[0,1],[0,-1]]

        q = deque()
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 2:
                    q.append((i,j))
                if grid[i][j] == 1:
                    fresh += 1

        time = 0
        if fresh == 0:
            return time

        while q:
            size = len(q)
            time += 1
            for i in range(size):
                curr = q.popleft()
                for dx, dy in dirs:
                    r = dx + curr[0]
                    c = dy + curr[1]

                    if r >= 0 and c >= 0 and r < rows and c < cols and grid[r][c] == 1:
                            grid[r][c] = 2
                            q.append((r, c))
                            fresh -= 1
                            if fresh == 0:
                                return time

        return -1


                    

        