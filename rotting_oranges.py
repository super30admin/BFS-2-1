'''
994 Rotting Oranges
https://leetcode.com/problems/rotting-oranges/description/

You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.


Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.


Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.

1. BFS (preferred approach)
Perform level order traversal where each level is a unit of time. Return the no. of levels (time) after all oranges have rot.
Time: O(MN), Space: O(MN)
https://youtu.be/oSvkTfsqwko?t=1173

Key takeway: This is different from Game of Life problem because this problem has connected components. This means when a new orange rots in a cell, it affects the oranges in the neighboring cell. Those neighboring cells, in turn, affect their neighboring cells and so on.

2. DFS
Start DFS from every rotten orange and spread the rot to fresh ones with time incrementing by 1 with every dfs() call. Mutate the grid to record the time each orange became rotten. At the end, if any fresh orange remains, return -1, else return total time.
Time: O(MN) (amortized), Space: O(MN)
(worst case time is O(M^2 * N^2))
https://youtu.be/j7F9aPgF5y8?t=1730 (approach)
https://youtu.be/j7F9aPgF5y8?t=3646 (TC, SC)
https://youtu.be/cYgVxX5ssoo?t=510

'''
from collections import deque
from copy import deepcopy as dcp

def oranges_rotting_bfs(grid):
    '''
    BFS
    '''
    if not grid:
        return -1
    M, N = len(grid), len(grid[0])
    dirs = [[-1,0],[1,0],[0,-1],[0,1]] # U, D, L, R
    fresh = 0
    q = deque()
    for i in range(M):
        for j in range(N):
            if grid[i][j] == 1:
                fresh += 1
            if grid[i][j] == 2: # enque independent components (rotten oranges)
                q.append(((i,j)))

    if fresh == 0:
        return 0

    t = -1
    while q:
        K = len(q)
        t += 1
        for _ in range(K):
            x, y = q.popleft()
            for dir in dirs:
                x_, y_ =  x + dir[0], y + dir[1]
                if 0 <= x_ <= M-1 and 0 <= y_ <= N-1 and grid[x_][y_] == 1:
                    grid[x_][y_] = 2
                    fresh -= 1
                    q.append((x_, y_))
    if fresh == 0:
        return t
    else:
        return -1

def oranges_rotting_dfs(grid):
    '''
    DFS
    '''
    def dfs(i, j, steps):
        if i < 0 or i >= M or j < 0 or j >= N:
            return

        # if orange is not present, then nothing to do
        if grid[i][j] == NOT_PRESENT:
            return

        for dir in dirs:
            x, y = i + dir[0], j + dir[1]
            if 0 <= x <= M-1 and 0 <= y <= N-1:
                if grid[x][y] != NOT_PRESENT and grid[x][y] != ROTTEN:
                    if grid[x][y] > steps:
                        grid[x][y] = steps
                        dfs(x, y, steps + 1)
        return

    if not grid:
        return -1
    M, N = len(grid), len(grid[0])
    dirs = [[-1,0],[1,0],[0,-1],[0,1]] # U, D, L, R

    # We mutate the grid to maintain the time (0, 1, 2, ...)
    # to reach a specific cell. But we also want to maintain
    # the state of the cells (0=not present, 1=fresh, 2=rotten)
    # To avoid confusion between a) t=1 and fresh orange  or
    # b) t=2 and rotten orange, let's encode the states differently
    FRESH, ROTTEN, NOT_PRESENT = 99999, 0, -1
    # 99999 indicates the orange takes infinity time to rotten.
    # Hence, this is a fresh orange. 0 indicates the orange
    # takes 0 time to rotten. Hence, this is a rotten orange

    for i in range(M):
        for j in range(N):
            if grid[i][j] == 2:
                grid[i][j] = ROTTEN
            elif grid[i][j] == 1:
                grid[i][j] = FRESH
            elif grid[i][j] == 0:
                grid[i][j] = NOT_PRESENT

    for i in range(M):
        for j in range(N):
            if grid[i][j] == ROTTEN:
               dfs(i, j, 1)

    t = 0
    for i in range(M):
        for j in range(N):
            if grid[i][j] == FRESH:
                return -1
            t = max(t, grid[i][j])
    return t

def run_tests():
    tests = [ ([[2,1,1],[1,1,0],[0,1,1]],4),
              ([[2,1,1],[0,1,1],[1,0,1]],-1),
              ([[2,1,1],[1,1,1],[0,1,2]],2),
              ([[0,2]],0),
              ([[1]],-1),
              ([[0]],0),
              ([[0,2,2]],0),
    ]
    for test in tests:
        grid, ans = test[0], test[1]
        print(f"\nGrid (original) = {grid}")
        for method in ['bfs', 'dfs']:
            mat = dcp(grid)
            if method == 'bfs':
                steps = oranges_rotting_bfs(mat)
            elif method == 'dfs':
                steps = oranges_rotting_dfs(mat)
            print(f"Method {method}: Grid (after) = {mat}")
            print(f"Time taken to rot all oranges = {steps}")
            passed = (ans == steps)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}\n")
    print(f"\nDONE")

run_tests()