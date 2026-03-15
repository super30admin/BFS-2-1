#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 690: Employee Importance
    Link: https://leetcode.com/problems/employee-importance/

    Problem:
    You have a data structure of employee information including their id, importance,
    and list of subordinate ids. Given a target employee id, return the total importance
    value of the employee and all their subordinates (recursively).

    Approach:
    BFS. Build a hashmap of id → Employee for O(1) lookup. Seed the queue with the
    target id, then for each dequeued employee add their importance and enqueue all
    their direct subordinates.

    1️⃣ Build empMap: id → Employee object.
    2️⃣ Seed queue with the target id.
    3️⃣ Dequeue employee id, add importance, enqueue all subordinates.
    4️⃣ Return accumulated importance when queue is empty.

    Note: queue.extend(subordinates) works; queue.append(generator) does NOT
    (lazy generators are enqueued as a single object, not individual items).

    // Time Complexity : O(n)
        Every employee is visited at most once.
    // Space Complexity : O(n)
        Hashmap and queue each hold at most n entries.

"""

from collections import deque
from typing import List


# Definition for Employee.
# class Employee:
#     def __init__(self, id: int, importance: int, subordinates: List[int]):
#         self.id = id
#         self.importance = importance
#         self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        empMap = {}
        for employee in employees:
            empMap[employee.id] = employee

        queue = deque()
        queue.append(id)
        imp = 0

        while queue:
            emp = queue.popleft()
            imp += empMap[emp].importance
            # queue.extend(empMap[emp].subordinates) — built-in to flatten list and enqueue each item
            for sub in empMap[emp].subordinates:
                queue.append(sub)

        return imp

    '''
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # Two separate maps for importance and subordinates.
        empImportanceMap = {}
        empSubordinateMap = {}
        queue = deque()
        importance = 0

        for employee in employees:
            if employee.id == id:
                for sub in employee.subordinates:
                    queue.append(sub)
                importance += employee.importance
            empImportanceMap[employee.id] = employee.importance
            empSubordinateMap[employee.id] = employee.subordinates

        while queue:
            currEmployeeId = queue.popleft()
            importance += empImportanceMap[currEmployeeId]
            for sub in empSubordinateMap[currEmployeeId]:
                queue.append(sub)

        return importance
    '''
