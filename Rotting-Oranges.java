// ## Problem 1

// Rotting Oranges(https://leetcode.com/problems/rotting-oranges)

In this problem there is a cell which is impacting neighbour and that neighbor is impacting other neighbor and so on.
So it is nor a matrix problem but a BFS problem

Now in this we will use BFS to solve in which we will add the elements with value 2 in queue and keep a size variable 
so that we can keep track of the levels

we will poll from the queue and go to valid elements above, below, left, right to see if it is fresh and if so add it in 
a queue and make it a rotten.
like this we will also maintain a count of fresh so that ones they are inserted we will decrement the count so that at 
the end we can know that all are rotten or not

Time Complexity : O(m*n) 
Space Complexity :O(m*n)

class Solution {
    public int orangesRotting(int[][] grid) {
        //Best case check
        if(grid==null || grid.length==0){
            return 0;
        }
        //time to keep track of minutes
        int time=0;
        int fresh=0;
        int m=grid.length;
        int n=grid[0].length;
        //Queue for BFS traversal we are storing an array of row and column
        Queue<int []> q=new LinkedList<>();
        //This will have constant space
        int [][] dirs={{0,-1},{-1,0},{0,1},{1,0}};
        // Tc : O(m*n)
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    //Initially we are adding rotten oranges
                    q.add(new int[]{i,j});
                }
                //We are keeping the count of fresh so we will decrease when they are rotten so if it became 0 we will not traverse through an matrix and check
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int size=0;
        if(fresh==0){
            return 0;
        }
        // Worst case O(m*n) elements in queue
        while(!q.isEmpty()){
            size=q.size(); 
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int row=curr[0];
                int col=curr[1];
                //O(1) as it will be constant with just 4 entries
                //Traversing and checking if up, down, left, right are valid and fresh
                for(int[] dir:dirs){
                    int r = row+dir[0]; 
                    int c = col+dir[1];
                    //If fresh marking it as rotten and making it 2 and decrementing the fresh count
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1){
                        q.add(new int[] {r,c});
                        grid[r][c]=2;
                        fresh--;
                    }
                }
                
            }
            //We are done with a level so time++
            time++;
        }

        if(fresh!=0){
            return -1;
        }
        //We are initially putting rotten and then doing time++ for that so time-1
        return time-1;
    }
}