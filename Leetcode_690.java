//way1
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//DFS
//Store id - employee in map for easy access
//Have a global result to store ans
//In helper - add imp of curr emp. And call helper for all the sub ordinates recursevly
//TC: O(n); SC:O(n)
class Solution {
    int result=0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        this.result=0;
        helper(map,id);
        return result;


        
    }

    private void helper(Map<Integer,Employee> map,int id){
        //


        //
        Employee emp=map.get(id);
        List<Integer> sub=emp.subordinates;
        result=result+emp.importance;
        for(int i=0;i<sub.size();i++){
            helper(map,sub.get(i));
        }
    }
}


//way2
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//DFS
//Store id - employee in map for easy access
//In helper - add imp of curr emp. And call helper for all the sub ordinates recursevly
//TC: O(n); SC:O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        int result=helper(map,id);
        return result;
        

        
    }

    private int helper(Map<Integer,Employee> map,int id){
        //


        //
        Employee emp=map.get(id);
        List<Integer> sub=emp.subordinates;
        int result=emp.importance;
        for(int i=0;i<sub.size();i++){
            result+=helper(map,sub.get(i));
        }
        return result;
    }
}

//way3
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//BFS
//Store id - employee in map for easy access
//Place initial employee in queue
//Till queue is not empty - poll queue. Add importance to result. Add all it's subordinates to queue
//TC: O(n); SC:O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        Queue<Employee> queue=new LinkedList<>();
        queue.add(map.get(id));
        int result=0;

        while(!(queue.isEmpty())){
            Employee curr=queue.poll();
            result+=curr.importance;
            List<Integer> sub=curr.subordinates;
            for(int i=0;i<sub.size();i++){
                queue.add(map.get(sub.get(i)));
            }
        }

        return result;

        
    }
}
