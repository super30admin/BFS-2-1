/**
 * @param {number[][]} grid
 * @return {number}
 Intuition:
All initially rotten oranges act as starting points and spread rot to adjacent fresh oranges. 
Using DFS, we pass a `time` value that represents the minute an orange becomes rotten. 
A cell is only updated if it is fresh or can be reached in less time than before, ensuring the minimum rotting time is recorded. 
After the spread, we scan the grid to find the maximum time taken; if any fresh orange remains unreachable, we return `-1`.
T.C: O(m*n)
S.C:(m*n)
 */
var orangesRottingDFS = function (grid) {
    let m = grid.length;
    let n = grid[0].length;
    const rottenIndices = [];
    let freshOrangeCount = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 2) {
                rottenIndices.push([i, j]);
            } else if (grid[i][j] === 1) {
                freshOrangeCount++;
            }
        }
    }
    if (freshOrangeCount === 0) return 0;

    // directions
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];

    const dfs = (currRow, currCol, time) => {
        // base case
        if (currRow < 0 || currCol < 0 || currRow >= m || currCol >= n ||
            grid[currRow][currCol] === 0) return;

        // action
        if (grid[currRow][currCol] != 1 && grid[currRow][currCol] < time) return;
        grid[currRow][currCol] = time;

        for (let [row, col] of directions) {
            const newRow = row + currRow;
            const newCol = col + currCol;

            dfs(newRow, newCol, time + 1);
        }
    }
    let result = 2
    for (let i = 0; i < rottenIndices.length; i++) {
        dfs(rottenIndices[i][0], rottenIndices[i][1], result);
    }

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) return -1;
            else result = Math.max(grid[i][j], result);
        }
    }
    return result - 2;
};