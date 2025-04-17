/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// BFS Solution
class Solution {

    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();
        Queue<Employee> queue = new LinkedList<>();
        int result = 0;
        for(Employee i : employees)
        {
            map.put(i.id, i);
            if(i.id == id)
            {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Employee temp = queue.poll();
            result = result + temp.importance;
            for(int i = 0; i < temp.subordinates.size(); i++ ){
                queue.add(map.get(temp.subordinates.get(i)));
            }
        }
        return result;
    }
}