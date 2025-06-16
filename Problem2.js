// ## Problem 2

// Employee Impotance(https://leetcode.com/problems/employee-importance/)
f
/**
 * Definition for Employee.
 * function Employee(id, importance, subordinates) {
 *     this.id = id;
 *     this.importance = importance;
 *     this.subordinates = subordinates;
 * }
 */
var GetImportance = function(employees, id) {
    //Time Complexity : O(V + E)
    //Space Complexity : O(N)
    let graph = new Map()
    let sum = 0
    for(let emp of employees){
        graph.set(emp.id,emp)
    }
    let queue = [graph.get(id)]
    while(queue.length){
        let current = queue.shift()
        sum += current.importance
        if(current.subordinates.length){
            for(let neighbour of current.subordinates)
            {
                queue.push(graph.get(neighbour))
            }
        }
    }
    return sum
};