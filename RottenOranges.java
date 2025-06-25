//Time Complexity- O(m*n)
//Space Complexity- O(m*n)
import java.util.*;
public class RottenOranges {
    static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n =  grid[0].length;
        Queue<Integer> que = new LinkedList<>();
        int [][]dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        int fresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) {
                    que.add(i);
                    que.add(j);
                }
            }
        }
        if(fresh == 0) return 0;
        int time = 0;
        while(!que.isEmpty()) {
            int len = que.size()/2;
            boolean flag = false;
            for(int i = 0; i < len; i++) {
                int r = que.poll();
                int c = que.poll();
                for(int[] d : dir) {
                    int cr = d[0]+r;
                    int cc = d[1]+c;
                    if(cr >=0 && cr < m && cc >= 0 && cc < n && grid[cr][cc] == 1) {
                        fresh--;
                        grid[cr][cc] = 2;
                        que.add(cr);
                        que.add(cc);
                        flag = true;
                    }
                }
            }
            if(flag) time++;
        }

        return fresh == 0 ? time : -1;
    }
    public static void main(String[] args) {
        int[][] grid1 = {{2,1,1}, {0,1,1}, {1,0,1}};
        System.out.println("Example 1:");
        int time = orangesRotting(grid1);
        if(time == -1 ){
            System.out.println("Not all oranges are rotten");
        } else  {
            System.out.println("Time in which all oranges turn rotten are: " + time);
        }

        int[][] grid2 = {{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println("Example 2:");
        time = orangesRotting(grid2);
        if(time == -1 ){
            System.out.println("Not all oranges are rotten");
        } else  {
            System.out.println("Time in which all oranges turn rotten are: " + time);
        }

    }
}
