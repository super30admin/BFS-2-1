/*
Time Complexity = O(M*N)
Space Complexity = O(M*N)
Where M is the number of rows and N is the number of coloumns.
*/
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int r=grid.size();
        int c=grid[0].size();
        int i,j,fresh=0;
        queue<vector<int>> q;
        for(i=0;i<r;i++)
            for(j=0;j<c;j++)
            {
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2)
                {
                    vector<int> x{i,j};
                    q.push(x);
                }
            }
        if(fresh==0)
            return 0;
        if(q.empty())
            return -1;
        vector<vector<int>> dir{{0,1},{1,0},{-1,0},{0,-1}};
        int lvl=0;
        int size;
        while(!q.empty())
        {
            size = q.size();
            for(int k=0;k<size;k++)
            {
                vector<int> temp(q.front());
                q.pop();
                for(i=0;i<dir.size();i++)
                {
                    int row=temp[0]+dir[i][0];
                    int col=temp[1]+dir[i][1];
                    if(row>=0 && row<r && col>=0 && col<c && grid[row][col]==1)
                    {
                        grid[row][col]=2;
                        vector<int> y{row,col};
                        q.push(y);
                        fresh--;
                    }
                }
            }
            lvl++;
        }
        if(fresh==0)
            return lvl-1;;
        return -1;
    }
};
