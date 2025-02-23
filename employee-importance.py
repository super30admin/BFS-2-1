"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
# Time O(max(length of employees, subsorderinates list size))
# Space O(max(length of employees, subsorderinates list size)) 
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        id_to_e = defaultdict(Employee)
        for e in employees:
            id_to_e[e.id] = e
        subs = id_to_e[id].subordinates
        imp = id_to_e[id].importance
        while len(subs) > 0:
            subId = subs.pop()
            if id_to_e[subId] != None:
                subs.extend(id_to_e[subId].subordinates)
                imp += id_to_e[subId].importance
        return imp


# Time O(max(length of employees, subsorderinates list size))
# Space O(max(length of employees, subsorderinates list size)) 
class Solution:
    def __init__(self):
        self.imp = 0
        self.id_to_e = defaultdict(Employee)

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        for e in employees:
            self.id_to_e[e.id] = e
        
        self.dfs(id)
        return self.imp
        
    def dfs(self, id: int):
        if self.id_to_e[id] == None: return
        subs = self.id_to_e[id].subordinates
        self.imp += self.id_to_e[id].importance
        for subId in subs:
            self.dfs(subId)
        