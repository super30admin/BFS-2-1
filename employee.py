# The getImportance method calculates the total importance value of an employee and their subordinates.

# Step 1: Determine Largest ID
#   - Iterate through the employees list to find the largest employee ID, ensuring enough space for indexing.

# Step 2: Build Graph Representation
#   - Create a list 'graph' where each index corresponds to an employee's ID.
#   - Populate 'graph' so that each index contains the respective Employee object.

# Step 3: Calculate Total Importance
#   - Start with the given employee ID and initialize 'result' with their importance value.
#   - Use the subordinates of the given employee to collect all direct and indirect subordinates:
#       - Append subordinates' subordinates recursively.
#   - Sum up the importance values of all subordinates.

# Final Result:
#   - Return 'result', which contains the total importance value of the employee and their subordinates.

# TC: O(n) - Each employee and their subordinates are processed once.
# SC: O(n) - Space is used for the 'graph' representation and subordinate processing.


from typing import List


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int: # type: ignore
        
        largest_id = float('-inf')
        for employee in employees:
            largest_id = max(largest_id, employee.id)

        graph = [] 
        for i in range(largest_id + 1):
            graph.append([])

        for employee in employees:
            graph[employee.id] = employee
        result = 0
        result += graph[id].importance
        subords = graph[id].subordinates
        for i in subords:
            subords += graph[i].subordinates
        print(subords)
        for i in subords:
            result += graph[i].importance
        
        return result