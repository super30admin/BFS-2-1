"""
TC: O(N) {we traverse each employee once}
SC: O(N) {in the worst case, all employees could be at the same level (e.g., a flat hierarchy), and we store all of them in the queue. The dictionary also stores all N employees.}

Approach:

We solve this problem using a Breadth-First Search (BFS) approach to traverse the employee hierarchy. The hierarchy can be thought of as a tree or a directed acyclic graph where employees are nodes and the subordinate relationship represents a directed edge.

First, we create a dictionary `d1` to map each employee's ID to their `Employee` object. This allows for constant-time `O(1)` access to any employee's data given their ID, which is more efficient than searching through the entire list.

We then initialize a queue with the starting `id` and a set to track `visited` employees to prevent recounting and infinite loops. We add the starting employee's importance to a running total `res`.

The BFS proceeds as follows: while the queue is not empty, we dequeue an employee ID. We retrieve their subordinates from our dictionary and add each unvisited subordinate to the queue and the `visited` set. We also add their importance to our running total.

After the traversal is complete, the `res` variable will contain the total importance of the target employee and all of their subordinates.

The problem ran successfully on LeetCode.
"""
from collections import deque, defaultdict
from typing import List
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        visited = set()
        q = deque() #we only store the ids
        res = 0

        for i in range(len(employees)):
            if employees[i].id == id:
                q.append(id)
                visited.add(id)
                res += employees[i].importance
                break
                
        d1 = defaultdict(list)

        for emp in employees:
            d1[emp.id] = [emp.importance, emp.subordinates]
        

        while q:
            idd = q.popleft()
            importance, subordinates = 0, []

            if idd in d1:
                importance, subordinates = d1[idd]
            
            for each in subordinates:
                if each not in visited:
                    res += d1[each][0]

                    if each:
                        q.append(each)
                        visited.add(each)

        return res
