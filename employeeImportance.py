# TC: O(n)
# SC: O(n)
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hmap={}

        for i in employees:
            hmap[i.id]=i
        
        root=hmap[id]
        q=deque([])
        q.append(root.id)
        result=0
        while q:
            curr=hmap[q.popleft()]
            result+=curr.importance
            q+=curr.subordinates
        
        return result