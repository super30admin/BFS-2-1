'''
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = collections.deque()
        rows, cols = len(grid), len(grid[0])
        freshCount = 0
        time = -1
        dirs = [(-1, 0), (0, -1), (1, 0), (0, 1)]
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    freshCount += 1
                elif grid[r][c] == 2:
                    q.append((r, c))
        q.append((-1, -1)) # to take care of edge case where grid is of length 1
        while q:
            l = len(q)
            for i in range(l):
                r, c = q.popleft()
                for dr,dc in dirs:
                    nr = r + dr
                    nc = c + dc
                    if nr >= 0 and nr < rows and nc >= 0 and nc < cols and grid[nr][nc] == 1:
                        q.append((nr, nc))
                        grid[nr][nc] = 2
                        freshCount -= 1
            time += 1
        if freshCount > 0 : return -1
        return time