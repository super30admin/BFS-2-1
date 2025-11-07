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
from collections import deque
class Solution(object):
    def getImportance(self, employees, id):
        """
        Basic BFS approach to solve the Employee Importance problem.
        Time Complexity: O(N) where N is the number of employees.
        Space Complexity: O(N) for the queue in the worst case.
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        
        # Create a mapping from employee id to Employee object for quick access
        emp_map = {emp.id: emp for emp in employees}
        total_importance = 0
        queue = deque([id])
        while queue:
            cur_id = queue.popleft()
            emp = emp_map[cur_id]
            total_importance += emp.importance
            for sub_id in emp.subordinates:
                queue.append(sub_id)
        return total_importance