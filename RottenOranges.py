#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = 0 #To track initial fresh oranges
        time = 0 #track unit of time after turning adjacent oranges to rotten in that iteration
        rows = len(grid)
        cols = len(grid[0])
        q = deque() #To store rotten oranges in the current iteration
        dirs = [[-1,0],[1,0],[0,-1],[0,1]] #Check the if neighbors are fresh oranges

        for i in range(rows):
            for j in range(cols):
                #Initially count the no. of fresh oranges
                if(grid[i][j]==1):
                    fresh+=1
                #Initially count the no. of rotten oranges and append to queue
                if(grid[i][j]==2):
                    q.append([i,j])
        #Until queue is empty or there are no left fresh oranges to be turned rotten
        while(len(q)>0 and fresh>0):
            qlen = len(q)
            #Check the neighbors of current rotten orange from leftmost in the queue
            for i in range(qlen):
                r,c = q.popleft()
                for dir in dirs:
                    row = dir[0] + r
                    col = dir[1] + c
                    #Boundary condition while checking for neighbors
                    if(row<0 or col<0 or row==rows or col==cols or grid[row][col]!=1):
                        continue
                    #If the neighbor is fresh then turn it to rotten i.e, 2
                    else:
                        grid[row][col] = 2
                        #Append it's coordinates to queue to check it's neighbors
                        q.append([row,col])
                        #Decrement from fresh as it has been turned to rotten
                        fresh -= 1
            #After the iteration is completed add a unit of time
            time+=1
        #At the end of matrix if there are no more fresh oranges left then return total time
        if(fresh==0):
            return time
        #Else return -1
        else:
            return -1


