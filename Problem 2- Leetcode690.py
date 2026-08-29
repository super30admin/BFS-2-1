#Time Complexity: O(n)
#Space Complexity: O(n)

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
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        """self.hashmap = {emp.id: emp for emp in employees}
        self.result = 0
        
        self.dfs(id)

        return self.result

    def dfs(self, id):
        emp = self.hashmap[id]
        self.result += emp.importance

        for subId in emp.subordinates:
            self.dfs(subId)"""
        self.hashmap = {}
        for emp in employees:
            self.hashmap[emp.id] = emp
        
        q = deque()
        q.append(id)
        result = 0

        while q:
            currId = q.popleft()
            currEmp = self.hashmap[currId]
            result += currEmp.importance
            for subId in currEmp.subordinates:
                q.append(subId)

        return result
        