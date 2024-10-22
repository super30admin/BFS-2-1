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
    hash_map = {}
    total_importance = 0
    def getImportance(self, employees, id): #DFS T.C->O(N) S.C->O(H)
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """

        self.hash_map = {}
        self.importance = 0
        for i in range(len(employees)):
            self.hash_map[employees[i].id] = employees[i]
        self.dfs(id)
        return self.total_importance
    def dfs(self,id):
        if id == None: return

        self.total_importance += self.hash_map[id].importance
        for emp in self.hash_map[id].subordinates:
            self.dfs(emp)
    


        