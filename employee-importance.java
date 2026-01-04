//TC: O(V+E)
//SC: O(n)

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee emp: employees){
            map.put(emp.id, emp);
        }
        System.out.println(map);
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee emp = map.get(eid);
            result += emp.importance;
            //q.add(emp.subordinates); cant do this beacuse it is a List
            for(int subId: emp.subordinates){
                q.add(subId);
            }
        }
        return result;
    }
}