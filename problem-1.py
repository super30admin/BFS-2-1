# Breadth first search

# Time Complexity : O(m*n)
# space complexity : O(m*n)

# Approach :

# use bfs
# add to queue all oranges which are rotten (value ==2)
# keep a count of all fresh oranges value == 1
# if there are no fresh oranges , return 0
# keep traversing the queue and keep searching for value ==1 oranges and keep making them 2 and add them to queue
# keep decrementing count of fresh oranges
# keep incrementing total minutes each time
# once queue is empty and still there are fresh oranges present, return -1 as they can never be found 4-adjacent dimensionally.
# if fresh oranges are zero , return total minutes -1


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        freshOranges = 0
        totalMin = 0
        q = deque()
        rows = len(grid)
        cols = len(grid[0])
        dirs = [[0, -1], [0, 1], [1, 0], [-1, 0]]

        if not grid:
            return -1

        for i in range(rows):
            for j in range(cols):
                if (grid[i][j]) == 2:
                    q.append([i, j])
                if (grid[i][j] == 1):
                    freshOranges = freshOranges+1

        if (freshOranges == 0):
            return 0

        while q:
            size = len(q)
            for i in range(size):
                poppedVal = q.popleft()
                for dirVal in dirs:
                    rowAffect = dirVal[0]+poppedVal[0]
                    colAffect = dirVal[1]+poppedVal[1]
                    while (rowAffect >= 0 and colAffect >= 0 and rowAffect < rows and colAffect < cols and grid[rowAffect][colAffect] == 1):
                        grid[rowAffect][colAffect] = 2
                        q.append([rowAffect, colAffect])
                        freshOranges = freshOranges-1

            totalMin = totalMin+1

        if (freshOranges != 0):
            return -1

        if (freshOranges == 0):
            return totalMin-1
