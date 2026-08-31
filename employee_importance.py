"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

"""
APPROACH:
1. Build a map from employee id to the employee object for quick lookups.
2. Use BFS starting from the target employee's id to explore the whole reporting chain.
3. For each employee processed, add their importance value to the running total.
4. Add all of that employee's subordinates to the queue so they get processed next.
5. Once the queue is empty, the total sum covers the employee and all subordinates under them.

PATTERN:
Graph/Tree BFS (Sum Over Reachable Nodes)

TIME COMPLEXITY:
O(n) - every employee is visited and processed at most once

SPACE COMPLEXITY:
O(n) - map stores all employees, queue can hold up to all employee ids

EXAMPLE:
Input:
employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]]
id = 1

Output: 11
Why: employee 1 has importance 5, plus subordinates 2 (importance 3) and 3 (importance 3) = 5+3+3
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:

        emp_map = {}  # maps employee id to employee object for fast lookup
        result = 0  # running total of importance values

        for employee in employees:
            emp_map[employee.id] = employee  # index employees by their id

        q = collections.deque()  # queue used for BFS
        q.append(id)  # start BFS from the target employee's id

        while q:
            current_emp_id = q.popleft()  # process next employee id
            current_emp_obj = emp_map[current_emp_id]  # look up employee object
            current_emp_importance = current_emp_obj.importance  # get their importance
            result = result + current_emp_importance  # add to running total

            # add all subordinates so their importance gets counted too
            for subordinate_id in current_emp_obj.subordinates:
                q.append(subordinate_id)
        
        return result  # total importance of employee and all subordinates