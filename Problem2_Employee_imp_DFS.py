"""
# Definition for Employee.
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution(object):
    def getImportance(self, employees, id):
        """
        Basic DFS approach to solve the Employee Importance problem.
        time Complexity: O(N) where N is the number of employees.
        Space Complexity: O(N) for the recursion stack in the worst case.
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        # Create a mapping from employee id to Employee object for quick access
        emp_map = {emp.id: emp for emp in employees}
        
        def dfs(emp_id):
            emp = emp_map[emp_id]
            total_importance = emp.importance
            for sub_id in emp.subordinates:
                total_importance += dfs(sub_id)
            return total_importance
        
        return dfs(id)
        