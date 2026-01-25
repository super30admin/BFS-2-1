/**
 * @param {Employee[]} employees
 * @param {number} id
 * @return {number}
 *Intuition:
 Here’s a **short, clean intuition paragraph**:
 We model the employee relationships as a graph where each employee points to their direct subordinates.

 To efficiently access employee records by id, we first store all employees in a map.

 Starting from the given employee id, we perform a BFS to traverse all subordinates, adding each employee’s importance to the total exactly once. Since every employee is visited once, the final sum represents the total importance of the employee and all of their direct and indirect subordinates.

 T.C: O(n)
 S.C: O(n)

 */
var GetImportance = function (employees, id) {
    const queue = [];
    // for O(1) lookup
    let adjMap = new Map();
    let totalImp = 0;
    for (let i = 0; i < employees.length; i++) {
        const { id: empId, importance, subordinates } = employees[i];
        adjMap.set(empId, employees[i]);
        if (empId === id) queue.push(employees[i]);
    }
    // bfs
    let idx = 0;
    while (idx < queue.length) {
        const { id: empId, importance, subordinates } = queue[idx++];
        totalImp += importance;
        for (let child of subordinates) {
            const childRecord = adjMap.get(child);
            queue.push(childRecord);
        }
    }
    return totalImp;
};