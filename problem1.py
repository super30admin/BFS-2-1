# problem 1

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        my_queue = []
        m = len(grid)
        n = len(grid[0])
        good_count = 0
        day_count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    my_queue.append((i,j))
                if grid[i][j] == 1:
                    good_count +=1
        if good_count == 0:
            return 0
        while(my_queue):
            curr_length = len(my_queue)
            day_count+=1
            for i in range(curr_length):
                curr_index = my_queue.pop(0)
                all_direction = [[0,-1],[-1,0],[0,1],[1,0]]
                for idx in all_direction:
                    r = idx[0] + curr_index[0]
                    c = idx[1] + curr_index[1]
                    if r >= 0 and r < m and c >= 0 and c < n:
                        if grid[r][c] == 1:
                            grid[r][c] = 2
                            my_queue.append((r,c))
                            good_count-=1 
                            if good_count == 0:
                                return day_count
        return -1
                        
