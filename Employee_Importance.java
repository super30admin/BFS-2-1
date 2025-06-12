// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    HashMap<Integer, Employee> map;
    int result = 0;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(int i = 0; i < employees.size(); i++){
            map.put(employees.get(i).id, employees.get(i));
        }
        helper(map.get(id));
        return result;
    }

    public void helper(Employee employee){
        result += employee.importance;
        List<Integer> sub = employee.subordinates;
        for(int i = 0; i < sub.size(); i++){
            helper(map.get(sub.get(i)));
        }
    }
}
