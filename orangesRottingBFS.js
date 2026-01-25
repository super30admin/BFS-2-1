/**
 * @param {number[][]} grid
 * @return {number}
Intuition:
We use Breadth-First Search (BFS) to simulate the rotting process minute by minute.
All initially rotten oranges are added to the queue first, since they start spreading rot at the same time.
In each BFS level, we process all currently rotten oranges and rot their adjacent fresh oranges, which will take exactly one minute. Each BFS level therefore represents one minute passing. 
We keep track of the number of fresh oranges and decrease it whenever an orange becomes rotten. If at the end all fresh oranges have rotted, the total time is the number of BFS levels minus one, because the level counter is incremented one extra time after the last rotting occurs.
If any fresh oranges remain unreachable, we return -1.
T.C: O(m*n)
S.C:(m*n)
 */
var orangesRottingBFS = function (grid) {
    const queue = [];
    let freshOrangeCount = 0;
    let level = 0;
    let m = grid.length, n = grid[0].length;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 2) {
                queue.push([i, j]);
            } else if (grid[i][j] === 1) {
                freshOrangeCount++;
            }
        }
    }
    if (freshOrangeCount === 0) return 0;

    // directions
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];

    // index to reduce shift operation
    let idx = 0;

    // bfs
    while (idx < queue.length) {
        const currentLevelLength = queue.length - idx;
        for (let i = 0; i < currentLevelLength; i++) {
            const [currRow, currCol] = queue[idx++];
            for (let [row, col] of directions) {
                const newRowIdx = row + currRow;
                const newColIdx = col + currCol;
                // check out of bounds
                if (newRowIdx < 0 || newColIdx < 0 || newRowIdx >= m || newColIdx >= n ||
                    grid[newRowIdx][newColIdx] === 0) continue;
                // action
                if (grid[newRowIdx][newColIdx] === 1) {
                    freshOrangeCount--;
                    grid[newRowIdx][newColIdx] = 2;
                    queue.push([newRowIdx, newColIdx]);
                }
            }
        }
        level++;
    }
    return freshOrangeCount === 0 ? level - 1 : -1;
};