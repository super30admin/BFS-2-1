# Time: O(m * n)
# Space: O(m * n)

# BFS APPROACH

# In the first pass calculate the number of fresh oranges and add all the rotten oranges in the queue.
# Then loop until either the fresh tomatoes are 0 or the q becomes empty (As when there is a tomatoe that cannot be rotten then the q will be empty)
# Have a track of time variable while process the children level by level, add 1 as we only add rotten tomatoes into the q.
# For a given current element from the q we go to 4 adjacent directions and check if the children is = 1 if it is then we rot it which means decreasing fresh count adding it to q and setting it's value to 2 to avoid duplicacy
# Then at the end if fresh count is 0 then return time else return -1

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        nFresh = 0
        q = deque()

        for m in range(len(grid)):
            for n in range(len(grid[0])):
                if grid[m][n] == 2:
                    q.append((m,n))
                elif grid[m][n] == 1:
                    nFresh += 1

        t = 0
        while nFresh > 0 and q:
            t += 1
            for _ in range(len(q)):
                currR, currC = q.popleft()
                direc = [[-1,0], [1,0], [0,-1], [0,1]]
                for r,c in direc:
                    newR = currR + r
                    newC = currC + c
                    if (0 <= newR < len(grid)) and (0 <= newC < len(grid[0])):
                        if grid[newR][newC] == 1:
                            grid[newR][newC] = 2
                            nFresh -= 1
                            q.append((newR,newC))
                
        return t if nFresh == 0 else -1