
/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function (grid) {
    let dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]];

    let time = 0;
    let count = 0;
    let queue = [];
    let rowLen = grid.length;
    let colLen = grid[0].length;
    const hasFreshOrange = (nextRow, nextCol) => {

        if ((nextCol < colLen && nextCol >= 0) &&
            (nextRow < rowLen && nextRow >= 0)
            && grid[nextRow][nextCol] === 1) { // boundary check cell and if it is a fresh orange
            console.log(nextRow, nextCol);
            return true;
        }
        return false;
    }

    for (let i = 0; i < rowLen; i++) { // First get the info of all the rotten oranges and fresh oranges count
        for (let j = 0; j < colLen; j++) {
            if (grid[i][j] === 2) {
                queue.push([i, j]);
            }
            else if (grid[i][j] === 1)
                count++;
        }
    }
    //Running BFS to collect the grid rotten oranges using queue 
    while (queue.length > 0 && count > 0) { // run till the queue becomes empty and count of fresh oranges is 0
        let size = queue.length;
        while (size > 0) { // process all the rotten oranges available at the same time
            let curr = queue.shift();
            for (let dir of dirs) { // check the current cell's 4-directional neighbors for fresh oranges

                let nextRow = curr[0] + dir[0];
                let nextCol = curr[1] + dir[1];

                if (hasFreshOrange(nextRow, nextCol)) {
                    queue.push([nextRow, nextCol]);
                    grid[nextRow][nextCol] = 2;
                    count--;
                }
            }
            size--;
        }
        time++;
    }

    if (count == 0) // if no fresh oranges remain then all are rotten in the time
        return time;
    else // not possible to rot all oranges
        return -1;
};