# problem 2 
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
        my_dict = {}
        for empl in employees:
            my_dict[empl.id] = empl 
        my_queue = deque()
        my_queue.append(my_dict[id])
        count = 0
        while my_queue:
            curr_empl = my_queue.popleft()
            count += curr_empl.importance
            for sub_empl in curr_empl.subordinates:
                my_queue.append(my_dict[sub_empl])
        return count

