//Time complexity : O(n)
//Space Complexity : O(N)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() == 0 || employees == null){
            return 0;
        }
        HashMap<Integer,Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int total = 0;
        for(Employee e : employees){
            map.put(e.id,e);
        }
        q.add(id);
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee emp = map.get(curr);
            total = total + emp.importance;
            for(int sub : emp.subordinates){
                q.add(sub);
            }
        }
        return total;
    }
}