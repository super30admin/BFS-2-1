// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    HashMap<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();

        for(Employee emp: employees){
            map.put(emp.id, emp);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        int result = 0;

        while(!q.isEmpty()){
            int currId = q.poll();

            Employee currObj = map.get(currId);

            result += currObj.importance;

            for(int subId : currObj.subordinates){
                q.add(subId);
            }
        }

        return result;
    }
}
