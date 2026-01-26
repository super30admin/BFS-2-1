class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        map={}
        for emp in employees:
            map[emp.id]=emp
        q=[id]
        result=0

        while q:
            curr=q.pop(0)
            result=result+map[curr].importance

            for sub in map[curr].subordinates:
                q.append(sub)
        return result