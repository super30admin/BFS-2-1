// Problem : Rotten Oranges
//  Time Complexity : O(m*n)
//  Space Complexity : O(m*n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this :  No

// Your code here along with comments explaining your approach in three
// sentences only
// 1. We first collect all the rotten oranges and add it to our queue
// 2. We then go level by level traversal (BFS) and keep the count of time
// 3. We push the neighboring oranges if they are fresh and in the end we
// were able to rot all oranges, we return (time - 1) otherwise -1

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int orangesRotting(vector<vector<int>> &grid) {
    int m = (int)grid.size();
    int n = (int)grid[0].size();
    int freshCount = 0;

    vector<pair<int, int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    queue<pair<int, int>> q;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          q.push({i, j});
        } else if (grid[i][j] == 1) {
          freshCount++;
        }
      }
    }
    if (freshCount == 0)
      return 0;
    int time = 0;
    while (!q.empty()) {
      int size = (int)q.size();
      for (int i = 0; i < size; i++) {
        auto front = q.front();
        q.pop();
        int r = front.first;
        int c = front.second;

        for (auto dir : dirs) {
          int dr = r + dir.first;
          int dc = c + dir.second;
          if (dr >= 0 && dr < m && dc >= 0 && dc < n && grid[dr][dc] == 1) {
            grid[dr][dc] = 2;
            freshCount--;
            q.push({dr, dc});
          }
        }
      }
      time++;
    }
    return freshCount == 0 ? time - 1 : -1;
  }
};
