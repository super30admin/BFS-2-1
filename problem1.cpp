// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Go over the grid, put the rotten orange coordinates into a queue and maintain a fresh orange count
// While queue is non empty and there are fresh oranges remaining, start BFS from each rotten orange and update its fresh neighbors to 2 and push these neighbors into the queue
// At the end of each while loop iteration, increment the time taken 

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int time = 0;
        int fresh = 0;
        int m = grid.size();
        int n = grid[0].size();
        queue<pair<int, int>> q;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    q.push({i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        vector<vector<int>> dirs = {{0, 1}, {0,-1}, {1,0}, {-1,0}};
        while(!q.empty() && fresh > 0) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                auto[r, c] = q.front();
                q.pop();
                for(auto& dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.push({nr, nc});
                    }
                }
            }
            time++;
        }
        if(fresh > 0) return -1;
        return time;
    }
};