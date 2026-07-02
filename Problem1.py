## Problem 1

# Rotting Oranges(https://leetcode.com/problems/rotting-oranges)
import collections
from typing import List

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        # ==========================================================
        # 1. BFS SOLUTION (Active)
        # ==========================================================
        # TIME COMPLEXITY: O(R * C)
        #   - R is the number of rows, C is the number of columns.
        #   - We scan the grid initially O(R * C).
        #   - During the BFS, each cell is added to the queue at most once.
        # 
        # SPACE COMPLEXITY: O(R * C)
        #   - In the worst-case scenario (e.g., all oranges are rotten initially), 
        #     the queue could hold all the cells in the grid at once.
        # ==========================================================
        
        rows = len(grid)
        cols = len(grid[0])
        q = collections.deque()
        freshOranges = 0
        
        # Step 1: Initialization
        # Scan the grid to find all initially rotten oranges (add to queue) 
        # and count how many fresh oranges exist.
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    q.append([r, c])
                if grid[r][c] == 1:
                    freshOranges += 1
        
        # If there are no fresh oranges to begin with, the time taken is 0.
        if not freshOranges:
            return 0
        
        directions = [[1, 0], [0, 1], [0, -1], [-1, 0]]
        time = 0
        
        # Step 2: Multi-Source Breadth-First Search
        # Process the queue layer by layer (minute by minute).
        while q:
            size = len(q)
            # Process all currently rotten oranges in this "minute"
            for _ in range(size):
                r, c = q.popleft()
                
                # Check all 4 adjacent neighbors
                for dr, dc in directions:
                    nr = r + dr
                    nc = c + dc
                    
                    # If the neighbor is within bounds and is a fresh orange
                    if nr >= 0 and nr < rows and nc >= 0 and nc < cols:
                        if grid[nr][nc] == 1:
                            q.append([nr, nc])     # Add it to the queue to rot its neighbors next minute
                            grid[nr][nc] = 2       # Mark it as rotten to prevent revisiting
                            freshOranges -= 1      # Decrement our fresh orange tracker
            
            # Increment time after a full layer (a full minute) of spreading is done
            time += 1
        
        # Step 3: Final Verification
        # If we finished spreading but fresh oranges still remain, they are unreachable.
        if freshOranges != 0:
            return -1
        
        # We subtract 1 because the while loop runs one final time for the last batch 
        # of rotten oranges, incrementing the timer even though they have no fresh neighbors left.
        return time - 1


        # ==========================================================
        # 2. DFS SOLUTION (Commented Out)
        # ==========================================================
        # TIME COMPLEXITY: O((R * C)^2) in the worst case. 
        #   - Unlike BFS which guarantees the shortest path immediately, DFS might reach a 
        #     cell via a longer path first. If it later finds a faster route, it has to 
        #     re-traverse and update those cells, leading to potential overlapping work.
        #
        # SPACE COMPLEXITY: O(R * C)
        #   - The depth of the recursion stack can go as deep as the total number of cells 
        #     in the grid in a worst-case "snake-like" path.
        # ==========================================================

        # rows = len(grid)
        # cols = len(grid[0])
        # directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        # 
        # def dfs(r, c, time):
        #     nonlocal grid, directions
        #     
        #     # Explore all 4 possible directions
        #     for dr, dc in directions:
        #         nr, nc = r + dr, c + dc
        #         
        #         if nr in range(rows) and nc in range(cols):
        #             # Only traverse if it is a fresh orange (1) OR if we found a FASTER 
        #             # route to an already affected orange (time + 1 < current recorded time).
        #             if grid[nr][nc] == 1 or grid[nr][nc] > time + 1:
        #                 grid[nr][nc] = time + 1    # Record the minute it rots (starting offset by 2)
        #                 dfs(nr, nc, time + 1)      # Recursively continue the rotting process
        #                 
        # # Step 1: Trigger a DFS from every initially rotten orange. 
        # # We pass '2' as the initial time because '2' is the marker for a rotten orange.
        # for r in range(rows):
        #     for c in range(cols):
        #         if grid[r][c] == 2:
        #             dfs(r, c, 2)
        #             
        # maxTime = 2
        # # Step 2: Scan the grid to find the maximum time recorded on any orange.
        # for i in range(rows):
        #     for j in range(cols):
        #         # If any 1s survived, they are unreachable
        #         if grid[i][j] == 1:
        #             return -1
        #         maxTime = max(maxTime, grid[i][j])
        #         
        # # Step 3: We started our "timer" at 2 (since 0 and 1 were taken for empty/fresh states), 
        # # so we must subtract 2 from our maximum found time to get the actual minutes elapsed.
        # return maxTime - 2