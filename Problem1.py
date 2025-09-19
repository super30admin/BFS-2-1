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
        # tc : O(n) 
        # sc : O(n)
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
       # intution
       # have a hashmap so its easy to search the id and its importance and its dependent subordrinates of it
       # hahsmap = {id as key and reference of this obejct}, if i have the object then can process that employee object and get the importance and its dependent subordinates
       # whill do it as bfs have a queue intially with the id node in it , and add the importance and also add the child nodes of it and run the whil loop until the queue isnot empty
       # so pop the node add its importance, and then add its subordinates ..

        id_map = {}

        for emp in employees: # tc : O(n)
            id_map[emp.id] = emp # by adding the obejct itself, its easier to get the importance and its subordiantes 

        q = deque()
        q.append(id)
        total_importance = 0

        while q : # tc ; O(n)
            emp_id = q.popleft()
            employee =  id_map[emp_id]
            total_importance += employee.importance
            for subId in employee.subordinates:
                q.append(subId)

        return total_importance



