
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        Queue<Employee> q=new LinkedList<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        Employee emp=map.get(id);
        int res=0;
        q.add(emp);
        while(!q.isEmpty()){
            emp=q.poll();
            res += emp.importance;
            for(int i:emp.subordinates){
                q.add(map.get(i));
            }
        }
        return res;
    }
}
