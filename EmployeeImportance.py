# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here we create a hashmap with key as id and value as employee object because we have to keep searching for the list of employees
# based on the id. Hence, doing it will reduce the searching time complexity from O(n) to O(1).
# Then starting from the given id, we loop and then go through the list of employees and add the importance.

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashmap = {}
        totalImportance = 0
        queue = deque()
        for employee in employees:
            hashmap[employee.id] = employee
        queue.append(id)
        while queue:
            currId = queue.popleft()
            currEmployee = hashmap[currId]
            totalImportance += currEmployee.importance
            if len(currEmployee.subordinates) > 0:
                for subId in currEmployee.subordinates:
                    queue.append(subId)

        return totalImportance


