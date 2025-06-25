//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
#include<iostream>
#include<vector>
#include<queue>
using namespace std;
class Solution {
public:
    int dir[4][2] = {{-1,0},{1,0},{0,1},{0,-1}};
    int m, n;
    int orangesRotting(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();
        int fresh = 0;
        queue<pair<int,int>> q;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.push({i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int time = 0;
        if(fresh == 0) 
            return time;
        while(!q.empty()){
            int size = q.size();
            time++;
            for(int i = 0; i < size; i++){
                auto curr = q.front(); 
                q.pop();
                for(auto& d : dir){  
                    int r = curr.first  + d[0];
                    int c = curr.second + d[1];
                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.push({r,c});
                        fresh--;
                        if(fresh == 0) 
                            return time;
                    }
                }
            }
        }
        return -1;
    }
};