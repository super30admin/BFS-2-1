## Problem 2

# Employee Impotance(https://leetcode.com/problems/employee-importance/)

# Method1: Using BFS
# N -- Total number of employees in the list
# Time Complexity : O(N) -- creating adjacency list + O(N) -- BFS or O(V + E) -- as one employee reports to only one manager for V = E
# Space Complexity : O(N) -- creating adjacency list + O(N/2) -- BFS or O(V + E) -- as one employee reports to only one manager for V = E
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The main thing is to structure the problem in the form of graph with given id at level 0. Here a subordinate can have only one manager. Since
# For given id, we would need to search and find its importance and subordinates
# Further for each and every subordinate we would need to search its
# importance and subordinates, so hash map is used to make search optimal. Here I have used BFS to traverse the graph

# Definition for Employee.
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        # :type id: int
        # :type importance: int
        # :type subordinates: List[int]
        #################
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

from collections import deque
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        # make a graph using given id as the starting point
        # For given id, we would need to search and find its importance and subordinates
        # Further for each and every subordinate we would need to search is 
        # importance and subordinates, so hash map to make search optimal

        # make the graph
        # the employee reference would allow us to access importance and subordinates easily
        graph = {}
        for employee in employees:
            graph[employee.id] = employee

        # Now we can use a traversal
        # BFS
        que = deque([id])
        totalImp = 0
        while(que):
            emp = graph[que.popleft()]
            totalImp += emp.importance
            for i in emp.subordinates:
                que.append(i)

        return totalImp

employee1 = Employee(1, 5, [2, 3, 9])
employee2 = Employee(2, 4, [4, 5])
employee3 = Employee(3, 3, [6, 7])
employee4 = Employee(4, 2, [8])
employee5 = Employee(5, 2, [])
employee6 = Employee(6, 1, [])
employee7 = Employee(7, 2, [])
employee8 = Employee(8, 1, [])
employee9 = Employee(9, 1, [])

sol = Solution()
print("Using BFS")
print(sol.getImportance([employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9], 1))
print(sol.getImportance([employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9], 3))


# Method1: Using DFS
# N -- Total number of employees in the list
# Time Complexity : O(N) -- creating adjacency list + O(N) -- DFS or O(V + E) -- as one employee reports to only one manager for V = E
# Space Complexity : O(N) -- creating adjacency list + O(h) -- DFS recursive stack space or O(V + E) -- as one employee reports to only one manager for V = E
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The logic is same as above. Just here we are using DFS for traversal. No need for base case here. The leaf nodes would not have further
# neighbors to explore. So recursion returns from there.

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
    def __init__(self):
        self.totalImp = 0
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        # DFS
        def dfs(id):
            # no need of base case
            # the recursion would stop once subordinates are empty

            emp = graph[id]
            self.totalImp += emp.importance

            for nei in emp.subordinates:
                dfs(nei)


        # make a graph using given id as the starting point
        # For given id, we would need to search and find its importance and subordinates
        # Further for each and every subordinate we would need to search is 
        # importance and subordinates, so hash map to make search optimal

        # make the graph
        # the employee reference would allow us to access importance and subordinates easily
        graph = {}
        for employee in employees:
            graph[employee.id] = employee

        # Now we can use a traversal
        # DFS
        self.totalImp = 0
        dfs(id)
        return self.totalImp

sol = Solution()
print("Using DFS")
print(sol.getImportance([employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9], 1))
print(sol.getImportance([employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9], 3))