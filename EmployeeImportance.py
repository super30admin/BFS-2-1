# Time Complexity : O(n), n is no of nodes in the subtree rooted at the given id
# Space Complexity : O(n), because the map is used to store the all employee objects and the queue is used as well
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Approach: BFS with a twist

from collections import deque
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
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        if employees is None:
            return 0
        # key is id and value is the Employee object
        map = {}
        # we will put ids in the queue
        q = deque()
        total = 0

        # traverse the grid, add employees objects in map
        # because we are not given a tree, its a list
        # and we will have to search for subordinates for the given id 
        for employee in employees:
            map[employee.id] = employee
        
        # bfs will start with the given id
        q.append(id)

        while q:
            # size variable is not needed
            curr = q.popleft() # id 
            # search for the id in hashmap, and store the emp object
            emp = map.get(curr)
            # add the importance as we do BFS
            total += emp.importance

            # now we check if we have valid subordinates for this id, and add them to our q
            for sub in emp.subordinates:
                # add ids in queue
                q.append(sub)
    
        return total

        

        