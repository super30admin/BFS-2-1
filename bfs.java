class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int cnt=0;
        if(fresh==0) return cnt;
                    while(!q.isEmpty()){
                        int size=q.size();
                        cnt++;
                        for(int i=0;i<size;i++){
                            int[] curr=q.poll();
                            for(int[] dir:dirs){
                            int sr=curr[0]+dir[0];
                            int pr=curr[1]+dir[1];
                            if(sr>=0 && pr>=0 && sr<m && pr<n && grid[sr][pr]==1){
                                grid[sr][pr]=2;
                                q.add(new int[]{sr,pr});
                                fresh--;
                                if(fresh==0) return cnt;
                            }
                        }
                    }
                    }
                    return -1;
    }
}
//problem 2
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        this.map=new HashMap<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(id);
        int ans=0;
        while(!q.isEmpty()){
            int currid=q.poll();
            Employee obj=map.get(currid);
            ans+=obj.importance;
            for(int subid:obj.subordinates){
                q.add(subid);
            }
        }
        return ans;
    }
}
