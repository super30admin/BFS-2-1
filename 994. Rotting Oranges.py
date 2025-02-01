#Time: O(m*n)
#space: O(m*n)

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m= len(grid)
        n= len(grid[0])
        fresh=0
        q= list()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 :
                    fresh += 1
                elif grid[i][j] == 2:
                    q.append([i,j])
        if fresh == 0:
            return 0
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        time =0
        while len(q) != 0 and fresh !=0:
            size = len(q)
            time += 1
            for _ in range(size):
                node = q.pop(0)
                for direction in dirs:
                    nr= node[0]+ direction[0]
                    nc= node[1]+ direction[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc <n:
                        if grid[nr][nc] == 1:
                            grid[nr][nc] = 2
                            q.append([nr,nc])
                            fresh -=1
        if fresh == 0:
            return time
        return -1
