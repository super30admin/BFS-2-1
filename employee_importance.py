###
# Approach:
# - Convert the list of Employee objects into a hashmap (adj_list) for O(1) lookup by id.
# - Start BFS traversal from the given employee id.
# - For each employee visited, add their importance to the result.
# - Add all their subordinates to the queue to process next.
# - Return the total accumulated importance.
#
# Time Complexity: O(n), where n is number of employees (each visited once)
# Space Complexity: O(n), for hashmap and queue
###
from collections import deque
class Employee:
    def __init__(self, id, importance, subordinates):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
class Solution:
    def getImportance(self, employees, id):
        adj_list = {}
        for emp in employees:
            k = emp.id
            adj_list[k] = emp
        
        queue = deque()
        result = 0
        queue.append(adj_list[id])
        
        while queue:
            curr = queue.popleft()
            result += curr.importance
            for sub in curr.subordinates:
                queue.append(adj_list[sub])
        return result
    
    def main(self):
        e1 = Employee(1, 5, [2, 3])
        e2 = Employee(2, 3, [])
        e3 = Employee(3, 3, [])

        employees = [e1, e2, e3]
        id_to_check = 1

        result = self.getImportance(employees, id_to_check)
        print("Total importance for employee", id_to_check, ":", result)

# Run the test
sol = Solution()
sol.main()