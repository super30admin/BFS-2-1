class EmployeeImportance {
    int total;
    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.isEmpty()){
            return 0;
        }

        for(Employee e: employees){
            map.put(e.id, e);
        }

        dfs(id);
        return total;
    }

    private void dfs(int id){
        //base

        //logic
        Employee emp = map.get(id);
        total = total + emp.importance;
        for(int sub: emp.subordinates){
            dfs(sub);
        }
    }
}
