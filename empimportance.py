from collections import deque

class Solution:
    def getImportance(self, employees, id):
        empMap = {emp.id: emp for emp in employees}

        q = deque([id])
        total = 0

        while q:
            empId = q.popleft()
            employee = empMap[empId]

            total += employee.importance

            for sub in employee.subordinates:
                q.append(sub)

        return total

    # TC = O(n)
    # SC = O(n)