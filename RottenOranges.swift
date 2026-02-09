//
//  RottenOranges.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/21/26.
//

class RottenOranges {
    
    class QueueUsingLinkedList<T> {

        private class LinkedListNode<T> {
            var value: T
            var next: LinkedListNode<T>?
            init(value: T) {
                self.value = value
            }
        }

        private var front: LinkedListNode<T>?
        private var rear: LinkedListNode<T>?
        private var count: Int = 0

        func enqueue(_ val: T) {
            let newNode = LinkedListNode(value: val)
            if (front == nil) {
                front = newNode
                rear = newNode
            } else {
                rear?.next = newNode
                rear = newNode
            }
            count += 1
        }

        func dequeue() -> T? {
            if (front == nil) {
                return nil
            }
            let frontValue = front?.value
            front = front?.next
            if (front == nil) {
                rear = nil
            }
            count -= 1
            return frontValue
        }

        var isEmpty: Bool {
            return count == 0
        }

        var size: Int {
            return count
        }
        }


    
    /*
     In how much tume, oranges will be rotten.
     If all oranges can't be rotten, then return -1.
     
      time compelxity - O(m * n)
      space complexity - O(m * n) worst case- when all oranges are rotten
      If only 1 ornge is rotten in the wntore matrix - N/4 , N = m * n, in queue we will hav1 ,1 -> 4 -> 16 -> 64 .... 1/4 doesn't matter, SO O(N) = O(m * n)
      
     */
    init() {
//        let output = orangesRotting([[2,1,1],[1,1,0],[0,1,1]])
        let o = rottenOrangesUsingDFS([[2,1,1],[1,1,0],[0,1,1]])
        print("o \(o)")
    }
    
    func orangesRotting(_ grid: [[Int]]) -> Int {
        var grid = grid
        let m = grid.count
        let n = grid[0].count
        var fresh = 0

        let directionsArray = [[0,1], [0, -1], [1, 0], [-1, 0]]
        var queue = QueueUsingLinkedList<(Int,Int)>()
        for i in 0..<m {
            for j in 0..<n {
                if (grid[i][j] == 2) {
                    queue.enqueue((i,j))
                }
                if (grid[i][j] == 1){
                    fresh += 1
                }
            }
        }
        if (fresh == 0) {
            return 0
        }
        var time = 0

        while (!queue.isEmpty) {
            let size = queue.size
            //processing a level
            for _ in 0..<size {
                guard let (cr, cc) = queue.dequeue() else {
                    continue
                }
                for dir in directionsArray {
                    let newR = cr + dir[0]
                    let newC = cc + dir[1]
                    //check bounds
                    if (newR >= 0 && newC >= 0 && newR < m && newC < n && grid[newR][newC] == 1) {
                        //change the state and enqueue
                        grid[newR][newC] = 2
                        queue.enqueue((newR, newC))
                        fresh -= 1
                        if (fresh == 0) {
                            return time + 1
                        }
                    }
                }
            }
            time += 1
        }
        //if any fresh orange is left then return -1
        if (fresh == 0) {
            return time - 1
        }
        return -1
    }
    
    /*
     DFS from the same node will cause the trouble. These kinds of issue can be present in many DFS problems.
     If connected component is there, with DFS, we can't achieve the solution.
     Trick - We can visit the node which are already visited if we are getting better time from some other path.
     It will handle infinite loop issue as well. It will optimize the time as well.
     Don't start time from 1 to avoid confusion between 1 (fresh) and 2 (rotten ) oranges. Start it from 3.
     Space complexity -> O(m * n) -> because in dfs, the recursion stack can have max of m*n elements when traversing
     time complexity - amortized m*n. From first node, we are doing full traversin to update the time.  For the 2nd DFS, it wouldn't traverse the whole matrix, it will check mostly the immediate neighbours. It doesn't go until the full lenth of matrix. With each node, we will be having lesser and lesser node to optimize. Hence time complexty becomes amortized m*n
     */
    
    func rottenOrangesUsingDFS(_ grid: [[Int]]) -> Int {
        var grid = grid

        let m = grid.count
        let n = grid[0].count

        //traverse through each node and initiate dfs. Visit the node again and again to optimize time
        for i in 0..<m {
            for j in 0..<n {
                if (grid[i][j] == 2) {
                    dfs(grid: &grid, row: i, column: j, time: 2)
                }
            }
        }

        var time = 2
        //check if I have any fresh orange.
        for i in 0..<m {
            for j in 0..<n {
                if (grid[i][j] == 1) {
                    return -1
                }
                time = max(grid[i][j], time)
            }
        }
        return time - 2
    }

    func dfs(grid: inout [[Int]], row: Int, column: Int, time : Int) {
        //base
        //bounds check
        if (row < 0 || column < 0 || row == grid.count || column == grid[0].count ) {
            return
        }

        //if grid value == 1 then only go inside because we will only rot the fresh oranges.
        //
        if (grid[row][column] < time && grid[row][column] != 1) {
            return
        }
        
        grid[row][column] = time

        var directions = [[1, 0], [-1,0], [0,1], [0, -1]]
        for dir in directions {
            let newR = row + dir[0]
            let newC = column + dir[1]
            dfs(grid: &grid, row: newR, column: newC, time: time + 1)
        }
    }
}

