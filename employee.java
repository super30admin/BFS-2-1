class Solution {
    HashMap<Integer,Employee>map;
    public int getImportance(List<Employee> employees, int id) {
        this.map=new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        Queue<Integer>q=new LinkedList<>();
        q.add(id);
        int res=0;
        while(!q.isEmpty()){
            int currid=q.poll();
            Employee curr=map.get(currid);
            res+=curr.importance;
            for(int sub:curr.subordinates){
                q.add(sub);
            }


        }
        return res;
        
    }
}