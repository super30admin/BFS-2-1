//Solved Successfully on leetcode and faced no issues
//Time complexity: O(n)
//Space complexoty: O(n)


class Solution {
    //BFS Approach
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee>map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id ,e);
        }
        Queue<Integer>queue = new LinkedList<>();
        //push given id into the queue
        queue.add(id);
        //start our bfs
        int result = 0;
        while(!queue.isEmpty()){
            int curr = queue.remove(); //pop the pushed id from queue n store in curr
            //do something - retrieve employee information n then importance of curr and add it to result
            Employee emp = map.get(curr);
            result += emp.importance;
            
            //process its subordinates
            for(int subid : emp.subordinates){
                queue.add(subid);
            }
        }
        return result;
    }
    //DFS Approach :
    // public int getImportance(List<Employee> employees, int id) {
    //     //hashmap to store employee id and its object(consists of everythis as pack)
    //     HashMap<Integer,Employee>map = new HashMap<>();
    //     for(Employee e : employees){
    //         map.put(e.id , e );
    //     }
    //     return dfs(id , map);
    // }
    // private int dfs(int id , HashMap<Integer,Employee>map){
    //     Employee emp = map.get(id); //retrieving details of given id in problem initially
    //     int result = emp.importance;
    //     for(int subid : emp.subordinates){
    //         result+=dfs(subid , map);
    //     }
    //     return result;
    // }
        
    
}