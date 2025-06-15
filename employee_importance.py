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

# Time Complexity: O(N)
# Space Complexity: O(N)
from collections import deque
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        queue = deque()
        dict_ = {}
        for each_employee in employees:
            dict_[each_employee.id] = each_employee
        imp = 0
        queue.append(id)
        while queue:
            emp_id = queue.popleft()
            employee_obj = dict_[emp_id] 
            imp += employee_obj.importance
            for each in employee_obj.subordinates:
                queue.append(each)
        return imp


        

        
        