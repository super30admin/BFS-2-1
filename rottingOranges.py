"""
Add all initially rotten oranges to queue
Apply BFS level by level where each level will be 1 minute
For each rotten orange, rot its neighbors and also track time
"""
"""
Time Complexity: O(R × C) – All cells visited once
Space Complexity: O(R × C) – queue and grid updates
"""

from collections import deque
from typing import List

class rottingOranges:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        queue = deque()
        fresh = 0

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r, c))
                elif grid[r][c] == 1:
                    fresh += 1

        if fresh == 0:
            return 0

        time = -1
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

       
        while queue:
            for _ in range(len(queue)):
                r, c = queue.popleft()
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        fresh -= 1
                        queue.append((nr, nc))
            time += 1

        return time if fresh == 0 else -1


if __name__ == "__main__":
    obj = rottingOranges()
    grid = [[2,1,1],[1,1,0],[0,1,1]]
    print(obj.orangesRotting(grid)) 

    grid2 = [[2,1,1],[0,1,1],[1,0,1]]
    print(obj.orangesRotting(grid2))  
