//Time O(n x m)
//Space O(nxm) if all oranges are rotten
//Leetcode : yes
//issue seen: none
class Solution {
public:
    int row[4] = {-1, 1, 0, 0};
    int col[4] = {0, 0, -1, 1};

    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int fresh = 0;
        queue<pair<int, int>> q;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    // store the location of rotten
                    q.push({i, j});
                }
                if (grid[i][j] == 1) {
                    // count the fresh
                    fresh++;
                }
            }
        }

        int minute = -1;
        if (fresh == 0)
            return 0;

        // walk the queue
        while (!q.empty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int r = q.front().first;
                int c = q.front().second;
                q.pop();

                // walk the neighbors
                for (int i = 0; i < 4; i++) {
                    int new_r = r + row[i];
                    int new_c = c + col[i];
                    // check boundaries
                    if (new_r < 0 || new_r > m - 1 || new_c < 0 ||
                        new_c > n - 1) {
                        continue;
                    }

                    if (grid[new_r][new_c] == 1) {
                        grid[new_r][new_c] = 2;
                        fresh--;
                        q.push({new_r, new_c});
                    }
                }
            }
            minute++;
        }
        if (fresh == 0)
            return minute;
        return -1;
    }
};
