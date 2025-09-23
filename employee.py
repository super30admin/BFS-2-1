# Time Complexity : O(N) where N is the number of nodes in the binary tree
# Space Complexity : O(N) where N is the number of nodes in the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am a hashmap to store the employee id and the employee object for O(1) access.
# I am using BFS to traverse the employee hierarchy starting from the given id.
# I am keeping a queue to store the employee ids to be processed.
# I am adding the importance of each employee to the result and adding their subordinates to the queue.
# Finally, I return the total importance.

from collections import deque
from typing import List
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashmap = {}
        for e in employees:
            hashmap[e.id] = e
        q = deque([id])
        res = 0
        while q:
            curr = q.popleft()
            e = hashmap.get(curr)
            res += e.importance
            for sub in e.subordinates:
                q.append(sub)
        return res





        