"""
BFS Approach -
TC - O(mn)
SC - O(mn)
"""


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None: return 0

        r = len(grid)
        c = len(grid[0])

        if r == 0: return 0

        q = deque([])
        freshOranges = 0

        # append first rotten orange to q
        for row in range(r):
            for col in range(c):
                if grid[row][col] == 2:
                    q.append([row, col])
                if grid[row][col] == 1:
                    freshOranges += 1

        # if no fresh oranges, return 0
        if freshOranges == 0: return 0

        # BFS
        minutes = 0
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while q:
            qsize = len(q)
            for i in range(qsize):
                # get curr element
                curr = q.popleft()
                for directions in dirs:
                    new_row = curr[0] + directions[0]
                    new_col = curr[1] + directions[1]
                    if new_row >= 0 and new_row < r and new_col >= 0 and new_col < c and grid[new_row][new_col] == 1:
                        q.append([new_row, new_col])
                        grid[new_row][new_col] = 2
                        freshOranges -= 1
            minutes += 1
        if freshOranges > 0: return -1
        return minutes - 1
