## Problem 1

# Rotting Oranges(https://leetcode.com/problems/rotting-oranges)

# Method1: Using BFS
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N)
# Space Complexity : O(M*N) -- worst cases when all oranges are rotten or only one rotten in the middle and rest call fresh. The queue size
# would increase exponentially and at the leaves it will be max = M*N/4 considering each rotten orrange having 4 fresh oranges
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We use BFS ie level order traversal. The first level starts from adding all rotten oranges to the queue. As they are already rotten, time 
# would be 0. Then we process their neighbors that are fresh, make it rotten and add them to the queue. Note that we process the children/
# neighbors in BFS before adding to the queue. After each level is processed we increment the time by 1, so we process all the children at a 
# level together so that we know when a particular level is completed and we can increment the time. Rather than going through matrix again
# to verify if all fresh have been rotten, we maintain a variable from start to keep the count of fresh oranges. Once this count reaches 0,
# we return the time. If after complete of BFS the count of fresh oranges still remains then we return -1

from collections import deque
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # initially rotten oranges would be at the same level
        # put them in the queue
        que = deque()
        # also count the number of fresh oranges
        freshCount = 0
        m = len(grid)# rows
        n = len(grid[0])# cols
        for i in range(m):
            for j in range(n):
                if(grid[i][j] == 1):
                    # fresh orange
                    freshCount += 1

                elif(grid[i][j] == 2):
                    # rotten orange
                    que.append((i,j))

        if(freshCount == 0):
            # no fresh oranges
            return 0

        if(len(que) == 0):
            # no rotten orange, but there are fresh oranges
            return -1

        time = 0
        direc = [[-1,0], [0,1], [1,0], [0,-1]]

        while(que):
            size = len(que)
            # go level by processing all children together
            for i in range(size):
                r,c = que.popleft()

                # process the neighbors
                for j in range(len(direc)):
                    nr = r + direc[j][0]
                    nc = c + direc[j][1]
                    # do bound check
                    if((0 <= nr < m) and (0 <= nc < n) and grid[nr][nc] == 1):
                        # it is fresh, make it rotten(ie it is visited now), reduce fresh count and add to the queue
                        grid[nr][nc] = 2
                        freshCount -= 1
                        if(freshCount == 0):
                            # all fresh have been rotten
                            return (time + 1)
                        que.append((nr, nc))
            
            # after processing each level we increase the time by 1
            time += 1

        return -1


sol = Solution()
print("Method:1 using BFS")
print(sol.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))
print(sol.orangesRotting([[2,1,1],[0,1,1],[1,0,1]]))
print(sol.orangesRotting([[0,2]]))


# Method2: Using DFS
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N) -- Average as we are memoizing the results
# Space Complexity : O(M*N) -- worst case when one rotten orange and all other fresh. So M*N recursive calls would go in the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# This DFS algo is based on concept that if we get a better time(that is current time < existing time), then we visit the node again. If we dont get a better
# time, we dont visit again. So for each rotten orange we do a DFS. Since states 0,1,2 are already used we start our time with an offset of 2.
# For first DFS, we can visit almost all nodes and some node more than once with better time. We note the time at these nodes. When we 
# do another DFS from another rotten orange, we only visit the nearby nodes with better time. With every extra DFS from rotten orange
# the number of nodes we visit again keep reducing. It is actually DFS with DP. We are memoizing our time at all nodes and visit the node again
# only if we get a better time. Here we start DFS from neighbors of rotten oranges ie time = 3 and we only visit again if 
# (current time < existing time). We skip when we visit the node again with same time

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # using DFS
        def dfs(grid, r, c, currTime, directions):
            # base
            # bounds
            if(r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0])):
                return

            # case when exiting time < current
            # takes care of case of 0 and 2 since we start with offset of 2.
            # so first neighbors of rotten orange would get time = 3
            # so case 0 and 2 would be ignored
            # and any greater current time than exiting time would be ignored
            if(grid[r][c] != 1 and currTime >= grid[r][c]):
                # dont visit current node 
                return

            # means currTime < existing time
            grid[r][c] = currTime

            # update the neighbors time
            for k in range(len(directions)):
                nr = r + directions[k][0]
                nc = c + directions[k][1]
                dfs(grid, nr, nc, currTime + 1, directions)





        m = len(grid)
        n = len(grid[0])
        directions = [(0,1), (1,0), (0,-1), (-1,0)] # right, down, left, up
        time = 2 # time is offset by 2
        # this is used to keep track of time of rotten oranges
        for i in range(m):
            for j in range(n):
                if(grid[i][j] == 2):
                    # do DFS from every rotten orange
                    for k in range(len(directions)):
                        nr = i + directions[k][0]
                        nc = j + directions[k][1]
                        dfs(grid, nr, nc, time + 1, directions)
                    # dfs(grid, m, n, time, directions)

        # now go over the grid again to check, if any fresh orange remains
        # Also note the time if no fresh orange remains
        timeFinal = 0
        for i in range(m):
            for j in range(n):
                if(grid[i][j] == 1):
                    # a fresh orange remains
                    return -1
                elif(grid[i][j] != 0):
                    timeFinal = max(timeFinal, grid[i][j])

        if(timeFinal > 0):
            # reduce the time by offset
            timeFinal -= time

        return timeFinal


sol = Solution()
print("Method:2 using DFS")
print(sol.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))
print(sol.orangesRotting([[2,1,1],[0,1,1],[1,0,1]]))
print(sol.orangesRotting([[0,2]]))


# Method3: Using DFS where we allow to visit equal time
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N) -- Average as we are memoizing the results
# Space Complexity : O(M*N) -- worst case when one rotten orange and all other fresh. So M*N recursive calls would go in the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# This DFS algo is based on concept that if we get a better time(that is current time < existing time), then we visit the node again. If we dont get a better
# time, we dont visit again. So for each rotten orange we do a DFS. Since states 0,1,2 are already used we start our time with an offset of 2.
# For first DFS, we can visit almost all nodes and some node more than once with better time. We note the time at these nodes. When we 
# do another DFS from another rotten orange, we only visit the nearby nodes with better time. With every extra DFS from rotten orange
# the number of nodes we visit again keep reducing. It is actually DFS with DP. We are memoizing our time at all nodes and visit the node again
# only if we get a better time. Here we start DFS from the rotten oranges ie time = 2 and we only visit again if 
# (current time <= existing time). We allow when visit the node again with same time as we start from time = 2

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # using DFS
        def dfs(grid, r, c, currTime, directions):
            # base
            # bounds
            if(r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0])):
                return

            # case when exiting time < current
            # takes care of case of 0 and 2 since we start with offset of 2.
            # so first neighbors of rotten orange would get time = 3
            # so case 0 and 2 would be ignored
            # and any greater current time than exiting time would be ignored
            if(grid[r][c] != 1 and currTime > grid[r][c]):
                # dont visit current node 
                return

            # means currTime < existing time
            grid[r][c] = currTime

            # update the neighbors time
            for k in range(len(directions)):
                nr = r + directions[k][0]
                nc = c + directions[k][1]
                dfs(grid, nr, nc, currTime + 1, directions)





        m = len(grid)
        n = len(grid[0])
        directions = [(0,1), (1,0), (0,-1), (-1,0)] # right, down, left, up
        time = 2 # time is offset by 2
        # this is used to keep track of time of rotten oranges
        for i in range(m):
            for j in range(n):
                if(grid[i][j] == 2):
                    # do DFS from every rotten orange
                    # we start from the rotten orange itself and not its neighbors
                    dfs(grid, i, j, time, directions)

        # now go over the grid again to check, if any fresh orange remains
        # Also note the time if no fresh orange remains
        timeFinal = 2
        for i in range(m):
            for j in range(n):
                if(grid[i][j] == 1):
                    # a fresh orange remains
                    return -1
                timeFinal = max(timeFinal, grid[i][j])


        return timeFinal - time



sol = Solution()
print("Method:3 Using DFS where we allow to visit equal time")
print(sol.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))
print(sol.orangesRotting([[2,1,1],[0,1,1],[1,0,1]]))
print(sol.orangesRotting([[0,2]]))