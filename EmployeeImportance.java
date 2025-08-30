// Time Complexity : O(n), n is the number of employees
// Space Complexity : O(n) (hashmap)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// To get the employee info in O(1), we put the employee objects in a hashmap. To find the importance of an employee, we can simply look it up in the hashmap. We add the subordinates' to a queue and iterate over them and add their importance in BFS.
// In DFS, we recursively visit each employee and their subordinates.

class Solution {

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap();
        for(Employee e: employees){
            map.put(e.id,e);
        }

        return dfs(map,id);
    }

    private int dfs(HashMap<Integer, Employee> map, int id){
        Employee e = map.get(id);
        int result = e.importance;
        for(Integer i: e.subordinates){
            result += dfs(map,i);
        }

        return result;
    }

    public int getImportanceBFS(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap();
        for(Employee e: employees){
            map.put(e.id,e);
        }

        Queue<Integer> q = new LinkedList();
        q.add(id);
        int result = 0;
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for(Integer i:e.subordinates){
                q.add(i);
            }
        } 

        return result;
    }
}