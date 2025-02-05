# Time complexity - O(n)
# Space complexity - O(n/2)

# Approach - bfs - Maintain a map (e_id: e*), everytime pop the element from queue, add the imp to total and
# add subordinates to the queue. Run till queue is empty.

from queue import Queue
from typing import List

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees is None or len(employees) == 0:
            return 0
        
        q = Queue()
        q.put(id)
        Map = dict()
        total = 0

        for e in employees:
            Map[e.id] = e # 1 : 1* (reference to the entire class of employee with id)
        
        while not q.empty():
            curr = q.get()
            c_e = Map[curr]
            total += c_e.importance
            for s in c_e.subordinates:
                q.put(s)
        return total