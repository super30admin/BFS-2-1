// In this problem, we are given a grid and need to find the minimum time required for all fresh oranges to become rotten. 
// We use bfs here to find time. We will first store all the rotten oranges locations in a queue and also count the number of fresh oranges.
// Then we will stasrt processing the queue, For each rotten orange we will rot its adjacent fresh oranges and add them to the queue.
// We will keep track of time taken to rot all the fresh oranges. If at the end there are still fresh oranges left, we will return -1.
// Time Complexity: O(m*n) where m is number of rows and n is number of columns in the grid.
// Space Complexity: O(m*n) for the queue in worst case when all oranges are rotten.
class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val dirs = arrayOf(
            intArrayOf(-1,0), //up
            intArrayOf(1,0), //down
            intArrayOf(0,1), //right
            intArrayOf(0,-1) //left
        )
        val m = grid.size
        val n = grid[0].size
        var fresh = 0

        val q : ArrayDeque<IntArray> = ArrayDeque()

        for(i in 0 until m) {
            for(j in 0 until n) {
                if(grid[i][j] == 2) {
                    q.addLast(intArrayOf(i,j))
                } else if (grid[i][j] == 1) {
                    fresh++
                }
            }
        }

        var time = 0

        if(fresh == 0) return time
        while(q.isNotEmpty()) {
            val size = q.size
            time++
            for(i in 0 until size) {
                val curr = q.removeFirst()

                for(dir in dirs) {
                    val r = curr[0] + dir[0]
                    val c = curr[1] + dir[1]

                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2
                        q.addLast(intArrayOf(r,c))
                        fresh--
                        if(fresh == 0) return time
                    }
                }
            }
        }
        return -1
    }
}