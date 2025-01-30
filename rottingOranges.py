class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # TC : O(m*n)
        # TC : O(m*n)
        if grid is None:
            return -1
        m,n = len(grid),len(grid[0])
        freshoranges = 0
        q = deque()
        timer = 0
        directions = [(-1,0),(1,0),(0,-1),(0,1)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    freshoranges += 1
                elif grid[i][j] == 2:
                    q.append((i,j))
        if freshoranges == 0:
            return 0
        if not q:
            return -1
        while q:
            cursize = len(q)
            while cursize > 0:
                x,y = q.popleft()
                cursize -= 1
                for dx,dy in directions:
                    i,j = x+dx,y+dy
                    if 0<=i<m and 0<=j<n and grid[i][j] == 1:
                        grid[i][j] = 2
                        freshoranges -= 1
                        q.append((i,j))
            timer += 1
        if freshoranges == 0:
            return timer-1
        else:
            return -1


        