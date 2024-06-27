# Depth first search


# Time Complexity : O(n)
# space complexity : O(n)

# Approach :

# use dfs
#  create a hashmap to store id as key and value as emp obj
#  retrieve emp obj details from the hashmap via the id
#  calculate the importance
#  do the same by going to the emp id by traversing the subordinates list
#  return total importance

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

        self.hashMap = dict()
        self.totalImportance = 0
        for emp in employees:
            self.hashMap[emp.id] = emp

        self.dfs(id)
        return self.totalImportance

    def dfs(self, id):

        empObj = self.hashMap[id]
        self.totalImportance = self.totalImportance + empObj.importance
        if empObj.subordinates:
            for subordinate in empObj.subordinates:
                self.dfs(subordinate)


# Breadth first search


# Time Complexity : O(n)
# space complexity : O(n)

# Approach :

# use dfs
#  create a hashmap to store id as key and value as emp obj
#  retrieve emp obj details from the hashmap via the id
#  add the emp id in the queue
#  calculate the size of the queue and and pop the id from the queue
#  calculate total importance, iterate over subordinate list and keep appending the emp id in the queue
#  continue the same procedure
# finally return the total importance


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

        self.hashMap = dict()
        self.totalImportance = 0
        self.q = deque()
        for emp in employees:
            self.hashMap[emp.id] = emp

        self.bfs(id)
        return self.totalImportance

    def bfs(self, id):

        empObj = self.hashMap[id]
        self.q.append(empObj.id)

        while self.q:

            size = len(self.q)
            for i in range(size):
                poppedVal = self.q.popleft()
                if poppedVal:
                    empObj = self.hashMap[poppedVal]
                    for subordinate in empObj.subordinates:
                        self.q.append(subordinate)
                    self.totalImportance = self.totalImportance + empObj.importance
