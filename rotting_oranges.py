"""
time - o(n)
space - o(n)
we do bfs where we add all rotten oranges to a queue, we explore all 4 nodes around it and if any orange is fresh, we mark it as rotten, add it to the queue and increment the time
finally we calculate how many fresh oranges remain, if none then we return max time
"""
from typing import List
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque()
        fresh_oranges = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    q.append((i,j,0))
                elif grid[i][j]==1:
                    fresh_oranges+=1
        if fresh_oranges==0:
            return 0
        max_time = -1
        traverse_order = [[-1,0],[1,0],[0,-1],[0,1]]
        visited=set()
        while q:
            i,j,time_elapsed = q.popleft()
            max_time = max(time_elapsed, max_time)
            for direction in traverse_order:
                if 0 <= i+direction[0] < len(grid) and 0 <= j+direction[1] < len(grid[0]) and (direction[0]+i,direction[1]+j) not in visited and grid[i+direction[0]][j+direction[1]]==1:
                    q.append((i+direction[0],j+direction[1],time_elapsed+1))
                    visited.add((i+direction[0],j+direction[1]))
                    fresh_oranges-=1
        if fresh_oranges>0 or max_time==-1:
            return -1
        return max_time
        