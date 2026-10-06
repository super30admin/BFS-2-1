# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using BFS. Initialize a queue with the given employee id
# Create a HashMap of each employee with key as id and value as Employee object of id, importance and subordinates
# Iterate over the queue until it is empty and pop the first id from the queue
# Check if that id is in HashMap and append its importance to res and subordinates to the queue
# Append the importance to res for each subordinates until we find the importance of all the subordinates and return res

from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees:
            return 0
        queue = deque([id])
        dict = {}
        for e in employees:
            dict[e.id] = e
        res = 0
        while queue:
            empid = queue.popleft()
            e = dict[empid]
            res += e.importance
            for subid in e.subordinates:
                queue.append(subid)
        return res