//Time complexity O(N) and space complexity O(N)
class Solution {
    public int getImportance(List<Employee> employees, int id) {

        HashMap<Integer,Employee> map = new HashMap<>();

        for(Employee e:employees){
            map.put(e.id,e);
        }

        Employee emp = map.get(id);
      
        Queue<Employee> queue = new LinkedList<>();

        queue.add(emp);
        int imp =0;

        while(!queue.isEmpty()){
            Employee em = queue.poll();
            imp+=em.importance;
            List<Integer> list = em.subordinates;
            int size = list.size();
            for(int i=0;i<size;i++){
                Employee r = map.get(list.get(i));
                queue.add(r);
            }
        }

        return imp;
   
    }
}

//Time complexity O(NM) and space complexity O(NM)
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        int fresh=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                    
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0) return 0;

        

        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

        int time =-1;

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i=0;i<size;i++){

                int[] rotten = queue.poll();
                
                for(int[] dir:dirs){
                    int nr = dir[0] + rotten[0];
                    int nc = dir[1] + rotten[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n){
                        if(grid[nr][nc]==1){
                            grid[nr][nc]=2;
                            fresh--;
                            queue.add(new int[]{nr,nc});
                        }
                    }
                    
                }
            }
            time++;
            
        }

        if(fresh==0){
            return time;
        }
        return -1;
    }

    
}
