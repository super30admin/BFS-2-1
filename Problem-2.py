# Time Complexity : O(N) where N is the number of employees
# Space Complexity : O(N) for the hashmap and recursion/queue
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Approach: We first create a hashmap mapping employee id to Employee object for O(1) lookups.
# Then we perform DFS or BFS starting from the given employee id, summing the importance
# of that employee and all their direct and indirect subordinates. This efficiently computes
# total importance without repeatedly scanning the employee list.

from collections import deque

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        emp_map = {emp.id: emp for emp in employees}
        
        total_importance = 0
        queue = deque([id])
        
        while queue:
            current_id = queue.popleft()
            employee = emp_map[current_id]
            
            total_importance += employee.importance
            
            for sub_id in employee.subordinates:
                queue.append(sub_id)
                
        return total_importance
