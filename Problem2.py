class Solution(object):
    # tc : O(m*n)
    # sc : O(m*n)
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # have to move one step in 4 directional of every rotten oranges, not one after one 
        # this is giving me inuttion to use bfs so thati can process all the rotten oranges neighbors at the same time
        # approach : have a queue and have all the rotten oranges indexes in it, process one direction of this rotten oranges and increment the time with 1
        # and then add the neighbors neighbors if they are fresh then add into the queue 
        # to make sure all the fresh oranges will be rottend, i will intial while adding rotten images into queue will also keep track of the coutn of fresh oranges
        # and while parsing in the queue when processing a direction neighbor and chagng the fresh to rotten drecrese the cunt of the fresh oranges
        # and when the queue is emoty and the fresh orangeis not 0 then there is some oranges left which cannot be rottend then will return -1

        fresh_count = 0
        q = deque()
        dirs = [[-1,0],[1,0],[0,1],[0,-1]] # 4 neighbors directions

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh_count+=1
                if grid[i][j] == 2:
                    q.append([i,j])

        time = 0
        # edge case check 
        if fresh_count == 0:
            return time # ntg to rotten 0 mins

        while q:
            n = len(q)
            time +=1 # the intial rotten images take 1 min to rotten the neighbors,
            # edge condition the last rotten orange we increase the time by 1 but there won't be any more oranges left to rotten so retunring time -1 
            for i in range(n): # once the intial q is emoty we increse the time by 1-> so we need this size paramter
              neighbor = q.popleft()
              for dire in dirs: # processing all the 4 neighbors as they all get rotten at the same min 
                nr = dire[0] + neighbor[0] # gives row index
                nc = dire[1] + neighbor[1] # gives col index

                if nr >= 0 and nc >= 0 and nr < len(grid) and nc < len(grid[0]) and grid[nr][nc] == 1:
                    grid[nr][nc] = 2 # fresh turned into rotten
                    fresh_count -=1 # decreased the cnt by 1
                    q.append([nr,nc]) # now this new rotten neighbor needs to be processed ( so adding in the queue)


        if fresh_count > 0:
            return -1 
        
        return time -1 

            

        
        
