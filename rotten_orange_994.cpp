class Solution {
public:
//TC: O(m*n)
//SC: O(m*n)
vector<vector<int>> dirs={{-1,0},{1,0},{0,-1},{0,1}};

    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> q;
        int m=grid.size();
        int n=grid[0].size();
        int fresh=0, time=0;

        if(grid.size()==0)
            return 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                    q.push({i,j});

                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        if(fresh==0)
            return 0;
        while(!q.empty())
        {
            int size=q.size();
            for(int index=0; index<size; index++)
            {
                auto val=q.front(); 
                q.pop();
                int row=val.first;
                int col=val.second;
                for(auto dir:dirs)
                {
                    int newR=row+dir[0];
                    int newC=col+dir[1];
                    if(newR>=0 and newR<m and newC>=0 and newC<n and grid[newR][newC]==1)
                    {
                        grid[newR][newC]=2;
                        q.push({newR, newC});
                        fresh--;
                    }
                }
               
            }
             time++;
        }
        if(fresh!=0)
            return -1;
        return time-1;
    }
};

