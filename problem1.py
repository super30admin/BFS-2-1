# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        R,C = len(grid), len(grid[0])

        fresh = set()
        rotten = []

        for i in range(R):
            for j in range(C):
                if grid[i][j] == 1:
                    fresh.add((i,j))
                elif grid[i][j] == 2:
                    rotten.append((i,j))
        
        def is_valid(r,c):
            return 0<=r<R and 0<=c<C

        queue = collections.deque()
        
        # init queue with rotten locations 
        queue.append(rotten)

        time = 0
        while queue:
            cur_rotten_list = queue.popleft()
            next_rotten_list = []
            time += 1
            for x,y in cur_rotten_list:
                for di,dj in [[0,1],[1,0],[0,-1],[-1,0]]:
                    dx,dy = x+di, y+dj
                    if is_valid(dx,dy) and grid[dx][dy] == 1:
                        fresh.remove((dx,dy))
                        grid[dx][dy] = 2
                        next_rotten_list.append((dx,dy))
            if next_rotten_list:
                queue.append(next_rotten_list)
        
        return time-1 if len(fresh) == 0 else -1