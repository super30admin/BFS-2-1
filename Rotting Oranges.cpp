// Problem: Rotting Oranges
// Time complexity: O(M * N), where M is the number of rows and N is the number of columns in the grid.
// Space complexity: O(M * N) for the queue used to store the rotten oranges.
// Did this code pass all test cases? Yes, it passed all test cases.

// Approach:
// 1. Traverse the grid to count fresh oranges and enqueue rotten oranges.
// 2. Use a queue to perform a breadth-first search (BFS) to rot adjacent fresh oranges.
// 3. For each minute, check all rotten oranges and rot their adjacent fresh oranges.
// 4. If there are still fresh oranges left after the BFS, return -1; otherwise, return the time taken to rot all oranges.



#include <vector>
#include <queue>
using namespace std;
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.empty()){return 0;}
        int time = 0; 
        int fresh = 0; 
        queue<pair<int,int>> rotten; 
        vector<pair<int,int>> direction = {{1,0},{0,1}, {-1,0}, {0,-1}}; 

        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid[0].size(); j++){
                if(grid[i][j] == 2){
                    rotten.push({i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        while(!rotten.empty() && fresh > 0){
            int size = rotten.size();
            for(int i = 0; i < size; i++){
                auto[x,y] = rotten.front();
                rotten.pop();

                for(auto[dx,dy]:direction){
                    int nx = x+dx;
                    int ny = y + dy;
                    if(nx >= 0 && nx < grid.size() && ny >= 0 && ny < grid[0].size() && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        rotten.push({nx,ny});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh > 0){return -1;}
        return time;
    }
};