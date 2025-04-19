'''
The key is getting all the oranges in the queue first, and do the level order Traversal

Time complexity --> O(m*n)--> Initially we are filling all the rotten oranges by
iterating through the grid, BFS also takes O(m*n)

Space Complexity --> 0(m*n) --> In the worst case we might need to put every orange in queue.
'''

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        queue = deque()
        fresh_org = 0
        visited = set()
        time=0
        directions =[[-1,0],[0,1],[1,0],[0,-1]]

        for i in range(len(grid)):
            for j in range(len(grid[0])):

                if grid[i][j]==2:
                    queue.append([i,j])
                    visited.add((i,j))
                if(grid[i][j]==1):
                    fresh_org+=1


        if(fresh_org==0):
            return 0



        while(queue):

            k = len(queue)
            time+=1

            for i in range(k):

                curr_dim = queue.popleft()
                curr_row = curr_dim[0]
                curr_col = curr_dim[1]

                for row, col in directions:
                    updated_row = row+curr_row
                    updated_col = col+curr_col

                    if (updated_row in range(0, len(grid)) and updated_col in range(0,len(grid[0]))):
                        if grid[updated_row][updated_col]==1 and (updated_row, updated_col) not in visited:
                            queue.append([updated_row, updated_col])
                            visited.add((updated_row, updated_col))
                            fresh_org-=1
                            if(fresh_org ==0):
                                return time

        return -1


