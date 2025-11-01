// Time Complexity : O(n).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We use hashmap to store mapping from employeeId to Employee object so that serach will be O(1). We perform BFS by adding the input id to the
// queue and adding it subordinates that are extracted from the hashmap also to the queue. In this step we almost maintain result by adding up the importance
// values.


class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        int result = 0;
        for(Employee emp : employees){ //hashmap for empId to employee object
            map.put(emp.id, emp);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);

        while(queue.size() > 0){
            int curr = queue.poll();
            Employee currEmp = map.get(curr); //get current Employee object data
            result += currEmp.importance; //calculate importance
            for(int subOrds : currEmp.subordinates) //add subordinates of current object to queue
                queue.add(subOrds);
        }
        return result;
    }
}