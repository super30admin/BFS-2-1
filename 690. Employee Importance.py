"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
#Time: O(n)
#space: O(n)
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hmap= dict()
        for item in employees:
            hmap[item.id]= item
        total=0
        q = [id]
        while len(q) != 0:
            size= len(q)
            node= q.pop(0)
            emp= hmap.get(node)
            total += emp.importance
            for subemp in emp.subordinates:
                q.append(subemp)
        return total
                

        
        
