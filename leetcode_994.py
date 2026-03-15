#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 994: Rotting Oranges
    Link: https://leetcode.com/problems/rotting-oranges/

    Problem:
    Given an m x n grid where 0 = empty, 1 = fresh orange, 2 = rotten orange,
    every minute any fresh orange adjacent (4-directionally) to a rotten orange
    becomes rotten. Return the minimum number of minutes until no fresh oranges
    remain, or -1 if impossible.

    Approach:
    Multi-source BFS. Seed the queue with all initially rotten oranges simultaneously.
    Expand level by level (each level = 1 minute). Track freshCount to detect
    unreachable fresh oranges.

    1️⃣ Scan grid: enqueue all rotten oranges, count fresh oranges.
    2️⃣ Early exit: if freshCount == 0, return 0.
    3️⃣ BFS level by level; for each rotten cell infect adjacent fresh cells and decrement freshCount.
    4️⃣ Increment time after each level.
    5️⃣ After BFS: if freshCount == 0 return time-1 (last increment was on empty queue), else -1.

    // Time Complexity : O(m * n)
        Every cell is visited at most once.
    // Space Complexity : O(m * n)
        Queue can hold all cells in the worst case.

"""

from collections import deque
from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        freshCount = 0
        queue = deque()

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    queue.append([i, j])
                if grid[i][j] == 1:
                    freshCount += 1

        if freshCount == 0:
            return 0

        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        time = 0

        while queue:
            size = len(queue)
            for _ in range(size):
                x, y = queue.popleft()
                for direction in directions:
                    X, Y = x + direction[0], y + direction[1]
                    if 0 <= X < len(grid) and 0 <= Y < len(grid[0]):
                        if grid[X][Y] == 1:
                            grid[X][Y] = 2
                            queue.append([X, Y])
                            freshCount -= 1
            time += 1

        if freshCount == 0:
            return time - 1
        return -1

    '''
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # DFS approach: overwrite cell values with the time they were infected.
        # Re-visit a cell if a shorter infection time is found (grid[X][Y] > time).
        self.directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        def dfs(grid, i, j, time):
            grid[i][j] = time
            for direction in self.directions:
                X, Y = i + direction[0], j + direction[1]
                if 0 <= X < len(grid) and 0 <= Y < len(grid[0]):
                    if grid[X][Y] == 1 or grid[X][Y] > time:
                        dfs(grid, X, Y, time + 1)

        mxTime = 2

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    dfs(grid, i, j, 2)

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    return -1
                mxTime = max(mxTime, grid[i][j])

        return mxTime - 2
    '''
