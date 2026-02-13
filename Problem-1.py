# Time Complexity : O(M × N)
# Space Complexity : O(M × N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Approach: We use multi-source BFS by first adding all initially rotten oranges
# into the queue and counting fresh oranges. Each BFS level represents 1 minute,
# and we rot all adjacent fresh oranges while decreasing the fresh count.
# At the end, if no fresh oranges remain, we return the total minutes taken;
# otherwise, we return -1.

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        result = 0
        queue = deque()
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append([i,j])
                if grid[i][j] == 1:
                    count += 1
        while queue:
            size = len(queue)
            for _ in range(size):
                top = queue.popleft()
                for dir in dirs:
                    nr = top[0]+dir[0]
                    nc = top[1]+ dir[1]
                    if nr >= 0 and nr < len(grid) and nc >= 0 and nc < len(grid[0]):
                        if grid[nr][nc] == 1:
                            count -= 1
                            grid[nr][nc] = -1
                            queue.append([nr,nc])
            result += 1
        if count == 0 and result!= 0:
            return result-1
        elif count == 0:
            return 0

        return -1




            
        

        
                
        
            

        