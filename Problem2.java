public class Problem2 {
    //t.c ->O(n)
    //s.c->O(n)
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size()==0){
            return 0;
        }
        //hmap for quick seach for the subordinates for curr emp
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }
        Queue<Integer> q = new LinkedList<>();
        int total = 0;
        q.add(id);
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee currEmp = map.get(curr);
            total = total + currEmp.importance;
            for(int subOrd : currEmp.subordinates){
                q.add(subOrd);
            }
        }
        return total;
    }
}
