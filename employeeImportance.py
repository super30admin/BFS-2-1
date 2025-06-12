class Employee:
    def __init__(self,id,importance,subordinates):
        self.id=id
        self.importance=importance
        self.subordinates=subordinates

class Solution:
    def getImportance(self,employees,id):
        empMap={emp.id:emp for emp in employees}

        def dfs(emp_id):
            emp=empMap[emp_id]
            total=emp.importance
            for sub_id in emp.subordinates:
                total += dfs(sub_id)
            return total 
        
        return dfs(id)

if __name__=="__main__":
    e1=Employee(1,5,[2,3])
    e2=Employee(2,3,[])
    e3=Employee(3,3,[])
    employees=[e1,e2,e3]

sol=Solution
print(sol.getImportance(employees,1))


        