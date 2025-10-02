# Time Complexity: O(M * N)
# Space Complexity: O(M * N)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        q = collections.deque()
        fc = 0 
        time = 1
        m,n = len(grid), len(grid[0])
        dirs = [(-1,0), (1,0), (0,1), (0,-1)]
        for i in range(m): 
            for j in range(n): 
                if grid[i][j] == 1:
                    fc+=1
                elif grid[i][j] == 2: 
                    q.append((i,j))
        if fc == 0: return 0
        if len(q) == 0: return -1
        while q: 
            size = len(q)
            # Per level Handling
            for _ in range(size): 
                i,j = q.popleft()
                for dx, dy in dirs: 
                    nx = i + dx
                    ny = j + dy
                    if nx >= 0 and ny >= 0 and nx < m and ny < n and grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        fc-=1
                        if fc == 0: return time
                        q.append((nx,ny))

            time+=1
        if time > 0: 
            return -1
            
        return time



        
