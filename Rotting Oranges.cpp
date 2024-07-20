// bfs
// time: O(mxn)
// space: O(mxn)

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {        
        // bfs
        queue<pair<int,int>> q;
        int freshCount = 0;
        int time = 0;
        // dirs = down, right, up, left
        vector<vector<int>> dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] == 2) {
                    q.push(make_pair(i,j));
                }
                else if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) {
            return time;
        }
        while(!q.empty()) {
            int sz = q.size();
            time++;
            for(int i = 0; i < sz; i++) {
                
                pair<int,int> curr = q.front();
                q.pop();
                // dirs = down, right, up, left
                for(int j = 0; j < 4; j++) {
                    int x = curr.first + dirs[j][0];
                    int y = curr.second + dirs[j][1];
                    if(x >= 0 && x < grid.size() && y >= 0 && y < grid[0].size()) {
                        if(grid[x][y] == 1) {
                            q.push(make_pair(x,y));
                            freshCount--;
                            grid[x][y] = 2;
                        }
                    }
                    
                }
                if(freshCount == 0) {
                    return time;
                }
            }
        }
        if(freshCount > 0) {
            return -1;
        }
        return time;
    }
};