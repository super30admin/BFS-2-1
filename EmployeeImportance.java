// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// DFS Approach
class Solution {
  int result;
  public int getImportance(List<Employee> employees, int id) {
    result = 0;
    Map<Integer, Employee> hashmap = new HashMap<>();
    // Add id-employee as key-value pair
    for(int i = 0; i<employees.size(); i++) {
      hashmap.put(employees.get(i).id, employees.get(i));
    }
    dfs(hashmap, id);
    return result;
  }

  void dfs(Map<Integer, Employee> hashmap, int id) {
    // Logic
    Employee employee = hashmap.get(id);
    List<Integer> subordinates = employee.subordinates;
    result += employee.importance;
    for(int i = 0; i<subordinates.size(); i++) {
      // Call dfs for every id in subordinates.
      dfs(hashmap, subordinates.get(i));
    }
  }
}

/*

// BFS APPROACH

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        Map<Integer, Employee> hashmap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(Employee e: employees) {
            hashmap.put(e.id, e);
        }
        queue.add(id);
        while(!queue.isEmpty()) {
            int currentID = queue.poll();
            result += hashmap.get(currentID).importance;
            List<Integer> currentSubordinates = hashmap.get(currentID).subordinates;
            for(int i = 0; i<currentSubordinates.size(); i++) {
                queue.add(currentSubordinates.get(i));
            }
        }
        return result;
    }
}*/