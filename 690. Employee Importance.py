# Time: O(n)
# Space: O(n)

# BFS APPROACH

# First go through the array and add the id with it's index in the hashmap to have the access to the importance and all it's childrens
# Add the id into the q of which we have to find the importance
# After adding the id add it's importance to the res variable and add it's childrens into the q
# Repeat the process until the q is empty

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hMap = {}
        for i in range(len(employees)):
            Id = employees[i].id
            hMap[Id] = i

        q = deque([id])
        res = 0

        while q:
            curr = q.popleft()
            emp = employees[hMap[curr]]
            res += emp.importance
            for sub in emp.subordinates:
                q.append(sub)

        return res
    

# DFS APPROACH

# Going through any child of the employee at a particular time

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hMap = {}
        for i in range(len(employees)):
            Id = employees[i].id
            hMap[Id] = i
            

        return self.dfs(hMap,id,employees)

    def dfs(self,hMap,id,employees):
        total = 0
        for sub in employees[hMap[id]].subordinates:
            total += self.dfs(hMap,sub,employees)
        return total + employees[hMap[id]].importance