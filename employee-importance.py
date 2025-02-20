# Time Complexity : O(n) - n is number of employees
# Space Complexity : O(n) - n is number of employees
#                           for BFS - space is the for queue, for DFS - space is for the recursion stack
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Maintain a map of eid to employee object for O(1) search

BFS
Add id in the queue, add its importance to the result and then pop the parent from queue and add all it's subordinates to the queue and so on..

DFS
Start with id and then recursively call on it's subordinates
"""

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

# BFS
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """

        employeeMap = {}
        for employee in employees:
            employeeMap[employee.id] = employee

        queue = deque()
        queue.append(id)
        result = 0

        while queue:
            eid = queue.popleft()
            e = employeeMap[eid]
            result += e.importance
            subordinates = e.subordinates
            for sid in subordinates:
                queue.append(sid)

        return result


# DFS
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """

        employeeMap = {}
        for employee in employees:
            employeeMap[employee.id] = employee

        self.result = 0
        self.helper(employeeMap, id)
        return self.result

    def helper(self, employeeMap, id):

        self.result += employeeMap[id].importance
        subordinates = employeeMap[id].subordinates
        for sid in subordinates:
            self.helper(employeeMap, sid)









