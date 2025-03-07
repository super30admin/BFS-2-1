// https://leetcode.com/problems/rotting-oranges/description/
// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Iterate through the grid and keep a count of rotten and fresh oranges. Push rotten ones into a queue.
// If fresh oranges are zero then return 0. 
// For each rotten orange, traverse in all 4 directions, see if there are fresh oranges, if yes then make them rotten and reduce the fresh oranges count.
// Have a time variable that is incremented for each level in the queue. If the fresh oranges become zero then return time else return -1.

class Solution {
    public:
        int orangesRotting(vector<vector<int>>& grid) {
            int n = grid.size();
            int m = grid[0].size();
            vector<pair<int,int>> dir = {{0,1}, {0, -1}, {1,0}, {-1,0}};
            queue<pair<int, int>> q;
            int freshCount = 0;
            int time = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(grid[i][j] == 2) q.push({i,j});
                    if(grid[i][j] == 1) freshCount++;
                }
            }
            if(freshCount == 0) return 0;
            while(!q.empty()){
                int size = q.size();
                for(int i=0; i<size; i++){
                    auto [x,y] = q.front();
                    q.pop();
                    for(auto [dx,dy]: dir){
                        int i = dx + x;
                        int j = dy + y;
                        if(i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1){
                            grid[i][j] = 2;
                            freshCount--;
                            q.push({i,j});
                        }
                    }
                }
                time++;
            }
            return freshCount != 0 ? -1 : time-1;
        }
    };