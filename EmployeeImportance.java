/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//Time complexity: O(n)
//Space complexity O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {

        //We will perform DFS
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees) {

            map.put(e.id, e);
        }

        //we will start performing dfs starting from id
        return dfs(map, id);  
    }

    public int dfs(HashMap<Integer, Employee> map, int id) {

        Employee emp = map.get(id);
        //first we cal the result and then we keep on adding to it
        int result = emp.importance;
        List<Integer> subIds = emp.subordinates;

        //Iterate over all the children and go deeper
        for(Integer sub: subIds) {

            result += dfs(map, sub);
        }

        //if we reach leaf just return its result, which will get added to its roots result and so on
        return result;
    }
}