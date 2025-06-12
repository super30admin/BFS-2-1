//Time Complexity: O(V+E)
//Space Complexity: O(V)
//Using BFS

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            //process the children
            for(int sId: e.subordinates){
                q.add(sId);
            }
        }
        return result;
    }
}

//Using DFS void based recursion

class Solution {
    int result;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(id, map);
        return result;
    }

    private void dfs(int eid, HashMap<Integer, Employee> map){
        //logic
        Employee e = map.get(eid);
        result += e.importance;
        for(int sId: e.subordinates){
            dfs(sId, map);
        }
    }

}