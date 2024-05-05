package BFS-2.1;

public class Problem2 {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        int result=0;
        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int currEmpID = q.poll();
            Employee currEmp = map.get(currEmpID);
            int currImp = currEmp.importance;
            result+=currImp;
            List<Integer> subord = currEmp.subordinates;
            for(int sub: subord){
                q.add(sub);
            }
        }
        return result;
    }
}
