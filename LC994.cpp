
// Time complexity O(mxn)
// Space complexity O(mxn)

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        vector<pair<int, int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int fresh = 0;
        int time = 0;

        queue<pair<int, int>> que;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    que.push({i, j});
                }
            }
        }

        if (fresh == 0) {
            return 0; // edge case, when there are no fresh oranges than can be rotten.
        }

        while (!que.empty()) {
            int size = que.size();  // why? since we are interested in how many levels are proccessed to increment time variable.
            for (int i=0; i<size; i++) {
                const auto [r, c] = que.front();
                que.pop();

                // neighbors
                for (const auto [dr, dc] : dirs) {
                    auto nr = r + dr;
                    auto nc = c + dc;

                    // bounds
                    if (nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == 1) {
                        que.push({nr, nc});
                        fresh--;
                        grid[nr][nc] = 2;
                    }
                }
            }
            time++;
        }

        if (fresh == 0) {
            return time-1;
        }
        return -1;
    }
};