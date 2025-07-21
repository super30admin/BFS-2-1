# BFS-2.1


## Problem 1

Rotting Oranges(https://leetcode.com/problems/rotting-oranges)
TC: O(m*n)
SC : O(m*n)

Approach: 
1. We are given a graph and then we have to return the amount of time taken to rot all the oranges
2. We will make a Queue of int array where we will store the row and col indexes of all the oranges are rotten and also calculate the fresh oranges
3. We will now rot the oranges till the queue is not empty and increase the time after the end of each loop and as we rot fresh oranges we will decrease the count of fresh oranges
4. We will check if the freshoranges are 0?
    a. yes then we will return time-1
    b. no we will return -1
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }

        int m = grid.length; // total rows
        int n = grid[0].length; // total columns
        int fresh = 0; //to calculate the total number of fresh oranges

        Queue<int[]> queue = new LinkedList<>();
        //I will add all the rotten oranges in my queue

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }

                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        if(queue.isEmpty()){
            return -1; // since there are no rotten oranges we simply return -1
        }

        //now we will rot the neighbour oranges and also calculate the total time taken to rot the oranges
        int time = 0;
        int[][] dir = {{0,-1}, {0,1}, {1,0}, {-1,0}}; // left, right, bottom, top

        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i = 0; i<len; i++){
                int[] rot = queue.poll();

                for(int[] d : dir){
                    int r = d[0] + rot[0];
                    int c = d[1] + rot[1];

                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1){
                        queue.offer(new int[]{r,c});
                        grid[r][c] = 2;
                        fresh--;
                    }
                }
            }

            time++;
        }

        if(fresh != 0){
            return -1;
        }

        return time-1;
    }
}

## Problem 2

Employee Impotance(https://leetcode.com/problems/employee-importance/)
TC: O(employees)
SC : O(employees)

Approach: 
1. We will make a hashmap of type integer and employee to store the id and employee object so that its easy for us to access the id's of the employees
2. we will do dfs where we will get the list of the subordinates of the given id and calculate the imp
3. We will return the importance of the given id


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> hm; 
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0){
            return 0;
        }

        //creating a map using hashmap since accessing the employees will become easier
       hm = new HashMap<>();

        for (Employee e : employees) {
            hm.put(e.id, e); // key = employee's ID, value = full Employee object
        }

        return dfs(id);

    }

    private int dfs(int id){
        
        List<Integer> sub = hm.get(id).subordinates;

        int imp = hm.get(id).importance;

        for(int s : sub){
            imp += dfs(s);
        }

        return imp;
    }
}
