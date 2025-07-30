# Time Complexity: O(n) where n is the number of employees
# Space Complexity: O(n) for the employee tree mapping
# Were you able to solve the problem? Yes
# Did you face any challenges while solving the problem? No

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

        if not employees or len(employees)==0:
            return 0

        # BFS

        emp_tree = {}
        q = deque()
        total = 0

        # create a mapping of employee id to Employee object for quick access
        for i in employees:
            if emp_tree.get(i.id, None) is None:
                emp_tree[i.id] = i
        
        
        # start BFS with the given employee id
        q.append(id)

        while q:
            # pop the first employee id from the queue
            # and get the corresponding Employee object from the mapping
            curr=q.popleft()

            emp = emp_tree.get(curr)
            
            # add the importance of the current employee to the total
            total += emp.importance

            # iterate through the subordinates of the current employee
            # and add them to the queue for further processing
            for sub in emp.subordinates:
                q.append(sub)

        return total




        