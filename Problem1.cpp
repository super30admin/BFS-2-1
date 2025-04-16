// Time Complexity : O(n*m) n is #of rows and m is columns.
// Space Complexity : O(n*m)  
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Perform BFS starting with all rotten oranges and moving all 4 neighbours which are fresh for next traversal.
// 2. Change value 1 to 2 of neighbours representing it as visited. 
// 3. Maintain minutes which will be size of queue after traversing all 4 neighbours for that element.

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> q;
        int n=grid.size();
        int m=grid[0].size();
        int rc=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.push(make_pair(i,j));
                }
                if(grid[i][j]==1){
                    rc++;
                }
            }
        }
        if(rc==0){return 0;}
        int ans=-1;
        int x=q.size();
        //cout<<x;
        while(!q.empty()){
            int ii = (q.front()).first;
            int jj = (q.front()).second;
            //cout<<ii<<' '<<jj<<'\n';
            if( ii != 0 && (grid[ii-1][jj] != 2) && (grid[ii-1][jj] == 1) ){
                q.push(make_pair(ii-1,jj));
                grid[ii-1][jj]=2;rc--;
            }
            if( jj != 0 && (grid[ii][jj-1] != 2) && (grid[ii][jj-1] == 1) ){
                q.push(make_pair(ii,jj-1));
                grid[ii][jj-1] = 2;rc--;
            }
            if( ii != n-1 && (grid[ii+1][jj] != 2) && (grid[ii+1][jj] == 1) ){
                q.push(make_pair(ii+1,jj));
                grid[ii+1][jj] = 2;rc--;
            }
            if( jj != m-1 && (grid[ii][jj+1] != 2) && (grid[ii][jj+1] == 1) ){
                q.push(make_pair(ii,jj+1));
                grid[ii][jj+1]=2;rc--;
            }
            x--;
            q.pop();
            if(x==0){
                x=q.size();ans++;
            }
        }
        if(rc!=0){
            return -1;
        }

        return ans;

    }
};