/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

//We use Breath first search and store Employees in a HashMap with there e.id as key and employee as value, so that it is learn to search for employee with eId, now we add employee with give id to queue, and traverse the queue until it empty, poll the value from queues, add it value to ans  and if it has any subordinates we add their employee object to queue and continue the process, and return ans at the end.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

//We use Depth First Search, same as BFS we add all the employees to Hashmap and traverse from given id using this map and recursion and add e.importance at each node to ans.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _690_Employee_Importance {

  /**** Method 1 ****/
  public int getImportanceBFS(List<Employee> employees, int id) {
    int ans = 0;
    HashMap<Integer, Employee> map = new HashMap<>();

    for (Employee e : employees) {
      map.put(e.id, e);
    }

    Queue<Employee> que = new LinkedList<>();
    que.add(map.get(id));

    while (!que.isEmpty()) {
      Employee ePolled = que.poll();
      ans += ePolled.importance;
      if (!ePolled.subordinates.isEmpty()) {
        for (int eId : ePolled.subordinates) {
          que.add(map.get(eId));
        }
      }
    }

    return ans;
  }

  /**** Method 2 ****/
  public int getImportanceDFS(List<Employee> employees, int id) {
    HashMap<Integer, Employee> map = new HashMap<>();

    for (Employee e : employees) {
      map.put(e.id, e);
    }

    return DFS(map, id);
  }

  private int DFS(HashMap<Integer, Employee> map, int id) {
    Employee e = map.get(id);
    if (e.subordinates.isEmpty()) {
      return e.importance;
    }

    int ans = e.importance;

    for (int eId : e.subordinates) {
      ans += DFS(map, eId);
    }

    return ans;
  }

  class Employee {

    public int id;
    public int importance;
    public List<Integer> subordinates;
  }
}
