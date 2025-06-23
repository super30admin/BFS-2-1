//builds a HashMap for quick lookup of employees by ID, then uses DFS via the helper() function to recursively sum up the importance of the given employee and all their subordinates. It accumulates importance values by traversing each employee's subordinates tree.
//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {

   public int getImportance(List<Employee> employees, int id) {

       HashMap <Integer, Employee> map = new HashMap<>();

       for(Employee e: employees){

           map.put(e.id, e);

       }

       return helper(map, id);

   }

   public int helper (HashMap<Integer, Employee> map, int id){

       int result = map.get(id).importance;

       for(int sub : map.get(id).subordinates){

           result += helper(map,sub);

       }     

       return result;

   }

}