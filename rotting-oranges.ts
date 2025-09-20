// Time complexity - O(m*n), m = number of rows, n = number of column
// Space complexity - O(m*n)
function orangesRotting(grid: number[][]): number {
	let totalFresh = 0;
	let q = [];

	// traverse through grid
	for (let i = 0; i < grid.length; i++) {
		for (let j = 0; j < grid[0].length; j++) {
			if (grid[i][j] === 1) {
				// if orange in the cell is fresh, increase total fresh count
				totalFresh++;
			} else if (grid[i][j] === 2) {
				// if orange in the cell is rotten, add the queue for traversal
				q.push([i, j]);
			}
		}
	}
	let totalTime = 0;
	// if there are no fresh oranges, return 0
	if (totalFresh === 0) return totalTime;

	let dirs = [
		[0, 1],
		[0, -1],
		[-1, 0],
		[1, 0],
	];

	// start traversal through all rotten oranges in the queue
	while (q.length > 0) {
		let size = q.length;

		// process all the oranges in the queue at the same time
		for (let i = 0; i < size; i++) {
			const curr = q.shift();

			// traverse in all 4 direction
			for (let dir of dirs) {
				let nr = dir[0] + curr[0];
				let nc = dir[1] + curr[1];

				if (
					nr >= 0 &&
					nc >= 0 &&
					nr < grid.length &&
					nc < grid[0].length
				) {
					if (grid[nr][nc] === 1) {
						// make the fresh orange rotten
						grid[nr][nc] = 2;
						// add the cell in the queue for processing
						q.push([nr, nc]);
						// reduce fresh oranges count
						totalFresh--;
						// if there are no fresh oranges, return current time
						if (totalFresh === 0) return totalTime + 1;
					}
				}
			}
		}
		// increase time for current iteration
		totalTime++;
	}

	// return -1 if we can not rotten all oranges
	return -1;
}
