// In this problem, we need to find the total importance of the employee. We use bfs to solve this. We will first create a map of employee id to employee object for quick access.
// Then we will start from the give id, add it to the queue and start processing. For each employee we will add their importance to the result and add their subordinates to the queue.
// Time Complexity: O(n) where n is number of employees.
// Space Complexity: O(n) for the map and queue.

/*
 *	// Definition for Employee.
 *	class Employee {
 *		var id:Int = 0
 *		var importance:Int = 0
 *		var subordinates:List<Int> = listOf()
 *	}
 */

class Solution {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val map = HashMap<Int, Employee>() 

        if(employees.isEmpty()) return 0

        for(emp in employees) {
            if (emp != null) {
                map[emp.id] = emp
            }
        }
        val start = map[id] ?: return 0
        val q : ArrayDeque<Int> = ArrayDeque()
        q.addLast(start.id)
        var result = 0
        
        while(q.isNotEmpty()) {
            val currId = q.removeFirst()

            val currEmp = map[currId] ?: continue
            result += currEmp.importance
            for(sub in currEmp.subordinates) {
                q.addLast(sub)
            }
        }
        return result
    }
}