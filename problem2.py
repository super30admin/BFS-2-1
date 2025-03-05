'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
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
        emp = {}
        for e in employees:
            emp[e.id] = e
        
        q = collections.deque()
        q.append(id)
        imp = 0
        while q:
            eId = q.popleft()
            imp += emp[eId].importance
            for s in emp[eId].subordinates:
                q.append(s)
        return imp