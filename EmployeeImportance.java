// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/*
 Create a mapping of eid and the index in employees array
 start with the starting id(given)
 get the importance and add it to result
 process all the subordinates into the queue. 
 repeat till queue is empty
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hm = new HashMap<>();
        int res = 0;
        for (Employee e : employees) {
            hm.put(e.id, e);
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(id);
        while (!que.isEmpty()) {
            int eid = que.poll();
            Employee e = hm.get(eid);
            res += e.importance;
            for (int sId : e.subordinates) {
                que.add(sId);
            }
        }

        return res;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/*
 Create a mapping of eid and the index in employees array
 start with the starting id(given)
 get the importance and add it to result
 process all the subordinates using dfs. 
 repeat till all subordinates are processed
*/



class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hm = new HashMap<>();
        int res = 0;
        for (Employee e : employees) {
            hm.put(e.id, e);
        }
        return dfs(id, hm);

    }

    private int dfs(int id, HashMap<Integer, Employee> map) {
        Employee e = map.get(id);
        int result = e.importance;
        for (int subId : e.subordinates) {
            result += dfs(subId, map);
        }
        return result;
    }
}