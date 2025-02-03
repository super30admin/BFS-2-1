from queue import Queue
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid ==None or len(grid) == 0:
            return 0
        
        q = Queue()
        Dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        rotten = []
        lvl = 0

        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.put([i,j])
                elif grid[i][j] == 1:
                    fresh += 1
        
        if fresh == 0:
            return 0
        lvl = 0
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get()
                for Dir in Dirs:
                    nr = curr[0] + Dir[0]
                    nc = curr[1] + Dir[1]
                    if nr < m and nc < n and grid[nr][nc] == 1 and nr>= 0 and nc >= 0:
                        q.put([nr,nc])
                        fresh -= 1
                        grid[nr][nc] = 2
            lvl += 1
            # print(fresh)
        if fresh == 0:
            return lvl -1
        else:
            return -1
        
        
            
                
            
            
        