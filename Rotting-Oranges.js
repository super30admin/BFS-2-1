var orangesRotting = function(grid) {
        let time = 0;
        let freshOranges = 0;
        let queue = [];
        let m = grid.length;
        let n = grid[0].length;
        const directions = [[0, -1], [0,1], [-1,0], [1,0]];
    
        for(let i = 0; i<m; i++){
            for(let j = 0; j<n; j++){
                if(grid[i][j] === 2) {
                    queue.push([i,j]);
                }
                else if(grid[i][j] === 1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges === 0) return time;
        while(queue.length > 0){
            let size = queue.length;
            for(let i = 0; i < size; i++){
                const[x, y] = queue.shift();
                for(const [dx,dy] of directions){
                    const newX = dx + x;
                    const newY = dy + y;
    
                    // let nr = x + dx;
                    // let nc = y+ dy;
                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] === 1) {
                        grid[newX][newY] = 2;
                        queue.push([newX,newY]);
                        freshOranges--;
                    }
                }
            }
            time++;
        }
        return freshOranges === 0 ? time-1 : -1;
    };