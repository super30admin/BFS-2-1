# https://leetcode.com/problems/employee-importance/

# Time Complexity- O(n2) Space Complexity- O(n)
class Employee:
    def __init__(self, id: int, importance: int, subordinates: list[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

from collections import deque
class Solution:
    def getImportance(self, employees: list['Employee'], id: int) -> int:
        # initialise the sum
        sum = 0
        # initialise the deque
        q = deque()
        # append the starting id
        q.append(id)
        
        while q:
            # pop the id
            curr = q.popleft()
            # iterate over the employees
            for emp in employees:
                # check the given id is same as the iterated id
                if emp.id == curr:
                    # add it's importance into the sum
                    sum += emp.importance
                    # iterate through the inner subordinate list
                    for sub_id in emp.subordinates:
                        # add that into the dequeue
                        q.append(sub_id)
        return sum

        
        