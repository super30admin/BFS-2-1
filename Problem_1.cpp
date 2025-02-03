// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 944: Rotting Oranges
// Approach: BFS
// TC: O(n)
// SC: O(n)

class Solution
{
public:
    int orangesRotting(vector<vector<int>> &grid)
    {

        // Base Case
        if (grid.empty() || grid[0].empty())
        {
            return 0;
        }

        int m = grid.size();
        int n = grid[0].size();

        // Count of fresh oranges and time
        int fresh = 0;
        int time = 0;

        // Queue for BFS
        queue<pair<int, int>> q;

        vector<pair<int, int>> dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L R

        // Loop through the grid
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 2)
                {
                    // Add it's position to the queue for BFS
                    q.push({i, j});
                }
                else if (grid[i][j] == 1)
                {
                    // Increment fresh orange count
                    fresh++;
                }
            }
        }

        // If no fresh oranges in grid then no time required to make rotten
        if (fresh == 0)
        {
            return 0;
        }

        // BFS
        while (!q.empty())
        {
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                auto curr = q.front();
                q.pop();
                for (auto &dir : dirs)
                {
                    int nr = curr.first + dir.first;
                    int nc = curr.second + dir.second;

                    // Explore all directions
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                        grid[nr][nc] == 1)
                    {
                        q.push({nr, nc});
                        fresh--;
                        grid[nr][nc] = 2;
                    }
                }
            }

            // Update time for orange to turn rotten
            time++;
        }

        if (fresh != 0)
        {
            return -1;
        }

        return time - 1;
    }
};
