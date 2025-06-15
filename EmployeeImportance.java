class Solution {
    //DFS
    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();

        for(Employee employee : employees){
            map.put(employee.id, employee);
        }

        return helper(id,map);

    }

    private int helper(int id, Map<Integer, Employee> map){
        Employee employee = map.get(id);

        int result =employee.importance;

        for(Integer subid : employee.subordinates){
          result+= helper(subid,map);
        }

        return result;
    }
    //BFS
    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int result = 0;
        while (!q.isEmpty()) {
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            //process children
            for (int sid : e.subordinates) {
                q.add(sid);
            }
        }

        return result;

    }

}