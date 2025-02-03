// In the problem, we are storing each emp's id as key in hashmap, it's object as it's value. Then adding the input id to the queue. Then running
// a loop till queue is empty. Now, for curr emp, add it's importance to the total, and add all it's subordinates to the queue. At last, return 
// total

// Time Complexity : O(n) - Number of subordinates
// Space Complexity : O(N) - We store all in Hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Using BFS
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // Base case
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        // Declare hashmap for storing employee Ids as key and their object as value
        HashMap<Integer, Employee> map = new HashMap<>();
        // Declare total variable for calc total importance
        int total = 0;
        // Loop for all the employee's object and put it in hashmap
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        // Declare queue for bfs
        Queue<Integer> q = new LinkedList<>();
        // Add the input id to it
        q.add(id);
        // Loop till queue is not empty
        while (!q.isEmpty()) {
            // Get the curr id from the queue
            int curr = q.poll();
            // Get it's object in O(1) time from our map(Note if we would have not stored
            // everything in map and we would have done linear search in given input, it
            // would have not been o(1)
            Employee emp = map.get(curr);
            // Add the importance of it to the current total
            total = total + emp.importance;
            // Now run a loop for it's list of subordinates
            for (int sub : emp.subordinates) {
                // Add them to the queue
                q.add(sub);
            }
        }
        // In end return total
        return total;
    }
}

// Using DFS
class Solution {
    // Declare hashmap for storing employee Ids as key and their object as value
    HashMap<Integer, Employee> map;
    // Declare total variable for calc total importance
    int total;

    public int getImportance(List<Employee> employees, int id) {
        // Base case
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        map = new HashMap<>();
        // Loop for all the employee's object and put it in hashmap
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        // Make a dfs call with id
        dfs(id);
        // Return total
        return total;
    }

    private void dfs(int id) {
        // Get the current id's object
        Employee emp = map.get(id);
        // Add it's importance to the total
        total = total + emp.importance;
        // For each of it's subordinates, run a loop
        for (int sub : emp.subordinates) {
            // Make a dfs call for each of it's subordinate
            dfs(sub);
        }
    }

}