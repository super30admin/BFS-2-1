// TC : O(m*n)
// SC : O(m*n)
class Solution
{
public:
    int orangesRotting(vector<vector<int>> &grid)
    {
        if (grid.size() == 0 || grid.empty())
        {
            return 0;
        }

        queue<vector<int>> store; // elements to be processed
        int minutes = 0;
        vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; // U D L R
        int fresh = 0;

        // keep track of fresh orange
        // keep track of rotten elements and push it to the queue
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid[i].size(); j++)
            {
                if (grid[i][j] == 2)
                {
                    vector<int> temp = {i, j};
                    store.push(temp);
                }
                else if (grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }

        if (store.empty() && fresh == 0)
        {
            return 0;
        }
        else
        {
            while (!store.empty())
            {
                int storeSize = store.size();
                for (int i = 0; i < storeSize; i++)
                {
                    vector<int> temp = store.front();
                    for (int j = 0; j < dirs.size(); j++)
                    {
                        int nr = temp[0] + dirs[j][0];
                        int nc = temp[1] + dirs[j][1];
                        // check if it is a valid row and column
                        // check if it is a fresh orange and only then push it in the queue
                        if (nr >= 0 && nr < grid.size() && nc >= 0 && nc < grid[0].size() && grid[nr][nc] == 1)
                        {
                            vector<int> updatedRotten = {nr, nc};
                            store.push(updatedRotten);
                            grid[nr][nc] = 2;
                            fresh--;
                        }
                    }
                    store.pop();
                }
                minutes++;
            }

            if (fresh == 0)
            {
                return minutes - 1; // since it added after the 1st element was popped from the queue
            }
        }

        return -1;
    }
};