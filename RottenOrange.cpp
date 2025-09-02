#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
First, collect all the rotten oranges and count how many fresh ones are there.
Then, every minute, rot the nearby fresh ones using BFS until none are left.
If we finish rotting all, return the time; else, return -1 since some can't be reached.
*/
class Solution{
public:
    int dirs[4][2] = {{0,1}, {1,0}, {-1,0},{0,-1}};
    int m,n;
    int orangesRotting(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();
        queue<pair<int,int>> q;
        int fresh = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.push({i,j});
                }else if(grid[i][j] == 1) fresh++;
            }
        }

        int time = 0;
        if(fresh == 0) return time;

        while(!q.empty()){
            int size = q.size();
            time++;
            for(int i=0; i<size; i++){
                auto curr = q.front(); q.pop();
                for(auto& dir : dirs){
                    int r = dir[0] + curr.first;
                    int c = dir[1] + curr.second;

                    if(r >=0 && c>=0 && r<m && c<n && grid[r][c]==1){
                        grid[r][c] = 2;
                        q.push({r,c});
                        fresh--;
                        if(fresh == 0) return time;
                    }  
                }
            }
        }
        //if(fresh == 0) return time-1;
        return -1;
    }
};
