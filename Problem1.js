// ## Problem 1

// Rotting Oranges(https://leetcode.com/problems/rotting-oranges)
//Understanding the need of freshCount was not intuative also had to remember we need do increment after we dequeue all the elements of queue



var orangesRotting = function(grid) {
    //Time Complexity : O(M X N)
    //Space Complexity : O(M X N)
    let n = grid.length
    let m = grid[0].length

    let time = 0
    let freshCount = 0
    let queue = []
    let direction = [[-1,0],[0,1],[1,0],[0,-1]]

    for(let i =0;i<n;i++){
        for(let j=0;j<m;j++){
            if(grid[i][j]==1) freshCount++
            if(grid[i][j]==2) queue.push([i,j])
        }
    }

    while(queue.length && freshCount > 0){
        let size = queue.length
        for(let i=0;i<size;i++){
            let [r,c] = queue.shift()
            for(let [dr,dc] of direction){
                let nr = r + dr
                let nc = c + dc
                //Bound Check
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1){
                    grid[nr][nc] = 2 //marked visted
                    queue.push([nr,nc]) // enqueue inside the queue
                    freshCount--
                }
            }
        }
        //Increse time when you travel 1 level
        time++
    }
    
    return freshCount === 0 ? time : -1;
    //Return time 


};

// var orangesRotting = function(grid) {
    //Time Complexity : O(M X N)
    //Space Complexity : O(M X N)
//     let rows = grid.length;
//     let cols = grid[0].length;

//     let maxTime = 0;
//     const directions = [[-1,0], [1,0], [0,1], [0,-1]];

//     function dfs(r, c, time) {

//         if (r < 0 || c < 0 || r >= rows || c >= cols) return;
//         if (grid[r][c] === 0) return; // Empty cell
//         if (grid[r][c] > 1 && grid[r][c] < time) return; // Already rotted earlier

//         grid[r][c] = time;
//         maxTime = Math.max(maxTime, time);

//         for (let [dr, dc] of directions) {
//             dfs(r + dr, c + dc, time + 1);
//         }
//     }
//     for (let r = 0; r < rows; r++) {
//         for (let c = 0; c < cols; c++) {
//             if (grid[r][c] === 2) {
//                 dfs(r, c, 2); // Start time as 2 (so we can subtract 2 later for final answer)
//             }
//         }
//     }
//     for (let r = 0; r < rows; r++) {
//         for (let c = 0; c < cols; c++) {
//             if (grid[r][c] === 1) return -1; // Found unrotted fresh orange
//         }
//     }

//     return maxTime === 0 ? 0 : maxTime - 2;
// };
