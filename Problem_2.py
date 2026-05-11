"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""


from collections import deque


class Solution:
    def getImportance(self, employees, id):
        adj = {}
        importance = {}
        for employee in employees:
            eid, imp, subs = employee.id, employee.importance, employee.subordinates
            importance[eid] = imp
            for s in subs:
                if eid in adj:
                    adj[eid].append(s)
                else:
                    adj[eid] = [s]
        print(adj)
        q = deque()
        result = importance[id]

        if id not in adj:
            return result
        for s in adj[id]:
            q.append(s)
        while q:
            front = q.popleft()
            result += importance[front]
            if front not in adj:
                continue
            for neigh in adj[front]:
                q.append(neigh)

        return result
