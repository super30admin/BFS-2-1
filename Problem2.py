## Problem 2

# Employee Impotance(https://leetcode.com/problems/employee-importance/)
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
        # ==========================================
        # BFS Solution
        # Time Complexity: O(N) - In the worst case, we visit every employee once (where N is the number of employees).
        # Space Complexity: O(N) - The dictionary takes O(N) space, and the queue can hold up to O(N) elements in the worst case.
        # ==========================================
        
        # Create a hash map to quickly look up an Employee object by their ID in O(1) time
        d = {}
        q = collections.deque()
        for e in employees:
            d[e.id] = e
            
        # Initialize the queue with the starting employee
        q.append(d[id])
        result = 0
        
        # Traverse the management hierarchy level by level
        while q:
            emp = q.popleft()
            
            # Add the current employee's importance to our total result
            result += emp.importance
            
            # Queue up all direct subordinates so they can be processed in subsequent iterations
            for s in emp.subordinates:
                q.append(d[s])
                
        return result

        # ==========================================
        # DFS Solution
        # Time Complexity: O(N) - Every employee is visited exactly once during the recursive calls.
        # Space Complexity: O(N) - O(N) for the dictionary and up to O(N) for the recursion stack in the worst-case (a straight line of subordinates).
        # ==========================================
        # 
        # # Create a hash map to quickly look up an Employee object by their ID
        # d = {}
        # for e in employees:
        #     d[e.id] = e
        # 
        # # Helper function to recursively calculate importance
        # def dfs(id):
        #     nonlocal d
        #     emp = d[id]
        #     
        #     # Base importance is the current employee's own importance
        #     result = emp.importance
        #     
        #     # Recursively traverse down the tree, adding the importance of all subordinates
        #     for sid in emp.subordinates:
        #         result += dfs(sid)
        #         
        #     return result
        # 
        # # Initiate the recursive search starting with the target ID
        # return dfs(id)