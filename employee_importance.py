def getImportance(self, employees: List['Employee'], id: int) -> int:
    self.smap={}
    for emp in employees:
        self.smap[emp.id]=emp
    self.result=0
    self.dfs(id)
    return self.result

def dfs(self,id):
    emp=self.smap[id]
    self.result+=emp.importance

    for sub in emp.subordinates:
        self.dfs(sub)