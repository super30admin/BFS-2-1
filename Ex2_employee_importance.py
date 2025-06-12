# Time Complexity: O(N), where N is the number of employees
# Space Complexity: O(N), for the queue/recursion stack and the hashmap
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from collections import deque
from typing import List


# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # BFS Approach
        # Step 1: Build a map from employee ID to Employee object
        emp_map = {}
        for emp in employees:
            emp_map[emp.id] = emp

        # Step 2: Perform BFS to accumulate importance
        q = deque()
        q.append(id)
        total_importance = 0

        while q:
            curr_id = q.popleft()
            curr_emp = emp_map[curr_id]
            total_importance += curr_emp.importance
            for sub_id in curr_emp.subordinates:
                q.append(sub_id)

        return total_importance

        # ------------------------------------------------------------
        # DFS-based Recursive Approach (with emp_map)
        # Time Complexity: O(N)
        # Space Complexity: O(N) recursion stack + hashmap

        # emp_map = {}
        # for emp in employees:
        #     emp_map[emp.id] = emp

        # def dfs(emp_id):
        #     emp = emp_map[emp_id]
        #     total = emp.importance
        #     for sub_id in emp.subordinates:
        #         total += dfs(sub_id)
        #     return total

        # return dfs(id)

        # ------------------------------------------------------------
        # Naive DFS Approach (no hashmap)
        # Time Complexity: O(N^2) in worst case (searching through the list)
        # Space Complexity: O(N) recursion stack

        # def dfs(emp_id):
        #     for emp in employees:
        #         if emp.id == emp_id:
        #             total = emp.importance
        #             for sub_id in emp.subordinates:
        #                 total += dfs(sub_id)
        #             return total
        #     return 0

        # return dfs(id)
