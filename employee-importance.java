/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// Time Complexity :O(n) + (n/2) => O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach in three sentences only:its BFS approach where i maintain a hashmap to map employee ud and corresponding importance and subords for O(1) lookup.then first i add id to queue and polling id from que by adding corresponding importance to imp value and pushing corresponding subords to que in
// then finallay i am able to traverse all the employees and subords

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int impCount=0;
        HashMap<Integer,Employee> sMap=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        for(Employee i:employees){
             sMap.put(i.id,i);   
        } 
        q.add(id);
        while(!q.isEmpty()){
            int size=q.size();
             for(int i=0;i<size;i++){
                    int e=q.poll();
                      Employee empObj=sMap.get(e);
                       impCount += empObj.importance;
                     List<Integer> subordinates=empObj.subordinates;
                    for(int j=0; j<subordinates.size();j++){
                        int subCount=subordinates.get(j);
                        q.add(subCount);
                    }
            }

        }
    
    return impCount;
    }
}