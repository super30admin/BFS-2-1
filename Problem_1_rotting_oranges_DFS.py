class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        #keep track of the count of fresh 
        #keep track of the rotten as a list and minutes
        #First we need to create a grid[i][j] and if its equal to 1 then increament fresh
        #and if grid[i][j] == 2 then append the index cell in rotten list
        #In another loop check while rotten exists and fresh greater than 0
        #Check if the neighbors of rotten are 1 and equal that to 1 and decrement fresh
        #count and increment minute count till fresh becomes 0 and return minutes and 
        #have a curr array that keeps track of curr rotten cell
        #Time complexity: O(mn) where m and n are rows and cols
        #Space complexity: O(mn) 
        fresh = 0
        minutes = 0
        rotten = []
        rows, cols = len(grid), len(grid[0])

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == 1:
                    fresh+=1
                elif grid[row][col] == 2:
                    rotten.append((row, col))
        
        while rotten and fresh>0:
            minutes +=1
            cur = []
            for r, c in rotten:
                check = [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]
                for i, j in check:
                    if i>=0 and j>=0 and i<rows and j<cols and grid[i][j]==1:
                        grid[i][j]=2
                        fresh -= 1
                        cur.append((i, j))
                        
            rotten = cur
            
        if fresh == 0:
            return minutes
        else:
            return -1