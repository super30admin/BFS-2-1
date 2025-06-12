# // Time Complexity :O(MxN)
# // Space Complexity :O(MxN)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# Is this BFS or DFS ? multiple fresh ones can be rotten at single time so BFS to get out of loop mantain a fresh counter , everytime check in four directions and if fresh ones are found
# add them to Queue

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m,n=len(grid),len(grid[0] ) #[m][n]
        q=deque()
        freshCount=0
        time=0
        #know locations of rotten and number of fresh 
        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    q.append([i,j])
                if grid[i][j]==1:freshCount+=1
        if freshCount==0:return 0
        #impossible 
        if len(q)==0:return -1


        while(len(q)):
            l=len(q)#at each level all fresh neighbours of rotten oranges  will become rotten thus BFS
            time+=1  #check for level
            for _ in range(l):
                rottenOrange=q.popleft()
                rm,rn=rottenOrange[0],rottenOrange[1]


                #apply in 4 directions
                dir=[[1,0],[0,1],[-1,0],[0,-1]]
                for i in dir:
                    j,k=i[0],i[1]
                    if -1<rm+j<m and -1<rn+k<n:
                        if grid[rm+j][rn+k]==1:
                            grid[rm+j][rn+k]=2
                            q.append([rm+j,rn+k])
                            freshCount-=1
            if freshCount==0:
                return time
        if freshCount==0:
            return time
        return -1
                    


