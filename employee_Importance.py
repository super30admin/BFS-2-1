"""
# Approach:
# 1. Use a hashmap (dictionary) to store employees' data for quick lookup by ID.
# 2. Use Depth-First Search (DFS) to calculate the total importance value recursively, starting from the given employee ID.
# 3. For each employee, add their importance and recursively add the importance of their subordinates.

# Time Complexity: O(n), where n is the number of employees. Each employee is visited once.
# Space Complexity: O(n), for the hashmap and the recursive call stack in the worst case.
# Did this code successfully run on Leetcode: Yes.
# Any problem faced: Initially, understanding how to efficiently traverse subordinates was challenging.

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # Create a hashmap for quick lookup by employee ID
        employee_map = {employee.id: employee for employee in employees}

        # Define a helper function for DFS
        def dfs(emp_id: int) -> int:
            employee = employee_map[emp_id]  # Get the employee object
            total_importance = employee.importance  # Start with the employee's importance
            for sub_id in employee.subordinates:  # Add importance of all subordinates
                total_importance += dfs(sub_id)
            return total_importance

        # Start DFS from the given ID
        return dfs(id)
